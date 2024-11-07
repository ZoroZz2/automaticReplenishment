package com.yh.ar.util;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @ClassName: ExportUtils
 * @Description: 导出工具类
 * @Author: system
 * @Date: 2024-10-29 15:14
 * @Version: 1.0
 **/
public class ExportUtils {

    /**
     * @Author: system
     * @Description: 数据导出
     * @Date: 2024-10-29 15:19:35
     * @Param: response
     * @Param: dataList
     * @Param: entityClass
     * @return: void
     **/
    public static <T> void exportData(HttpServletResponse response, List<Map<String, Object>> dataList,
                                      Class<T> entityClass) throws IOException {
        // 创建Excel工作簿
        Workbook workbook = WorkbookFactory.create(true);

        // 创建工作表
        Sheet sheet = workbook.createSheet(entityClass.getSimpleName());

        // 设置标题行的字体样式
        Font font = workbook.createFont();
        font.setBold(true); // 将字体设置为加粗样式

        // 获取表名
        Table tableAnnotation = entityClass.getAnnotation(Table.class);
        String tableName = "data";
        if (tableAnnotation != null) {
            tableName = tableAnnotation.name();
        }

        /**
         *    创建标题行
         * 1. 要根据实体类的 @Column(name = "姓名") 注解中的 name 值来设置标题行，
         * 2. 你可以通过反射获取实体类的字段名称。
         * 3. 可以使用 Class.getDeclaredFields() 方法来获取所有的字段，
         * 4. 然后使用 Field.getAnnotation() 方法获取 @Column 注解，最后通过 name() 方法获取注解中设置的名称。
         */
        Row headerRow = sheet.createRow(0);
        Field[] fields = entityClass.getDeclaredFields();

        // 数据不为空，写数据，为空，下载模板，模板无序号
        int columnIndex = 0;
        for (Field field : fields) {
            Column columnAnnotation = field.getAnnotation(Column.class);
            if (columnAnnotation != null) {
                String columnName = columnAnnotation.name();

                // 排除id、createTime、updateTime、status等属性的导出
                if (Objects.isNull(dataList)) {
                    if (!("id".equals(field.getName()) || "createTime".equals(field.getName())
                            || "updateTime".equals(field.getName()) || "status".equals(field.getName())
                    )) {
                        Cell headerCell = headerRow.createCell(columnIndex);
                        headerCell.setCellValue(columnName);

                        // 应用字体样式到标题单元格
                        CellStyle cellStyle = workbook.createCellStyle();
                        cellStyle.setFont(font);
                        headerCell.setCellStyle(cellStyle);

                        columnIndex++;
                    }
                } else {

                    Cell headerCell = headerRow.createCell(columnIndex);
                    headerCell.setCellValue(columnName);

                    // 应用字体样式到标题单元格
                    CellStyle cellStyle = workbook.createCellStyle();
                    cellStyle.setFont(font);
                    headerCell.setCellStyle(cellStyle);

                    columnIndex++;

                }
            }
        }
        /**
         * 1. 可以使用反射获取实体类的字段数量，
         * 2. 然后在循环中根据字段数来创建单元格
         */
        // 数据不为空-填充数据到Excel表格
        // 数据为空，下载模板
        if (Objects.nonNull(dataList)) {
            int rowNumber = 1;
            for (Map data : dataList) {
                Row row = sheet.createRow(rowNumber);

                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    Column columnAnnotation = field.getAnnotation(Column.class);
                    if (columnAnnotation != null) {
                        Cell cell = row.createCell(i);
                        setCellValue(cell, data, field);
                    }
                }

                rowNumber++;
            }
        }

        // 设置响应头信息
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("UTF-8");

        String encodedTableName = URLEncoder.encode(tableName, "UTF-8");
        String filename = encodedTableName + ".xlsx";
        response.setHeader("Content-Disposition", "attachment; filename=" + filename);

        // 将Excel写入响应输出流
        workbook.write(response.getOutputStream());

        // 关闭工作簿
        workbook.close();
    }

    /**
     * @Author: system
     * @Description: 根据字段的类型来设置单元格的值
     * @Date: 2024-10-29 15:23:28
     * @Param: cell
     * @Param: data
     * @Param: field
     * @return: void
     **/
    private static <T> void setCellValue(Cell cell, Map data, Field field) {
        field.setAccessible(true);
        try {
            Object value = data.get(field.getName());
            // 根据属性的类型来设置单元格的值
            if (value instanceof Integer) {
                cell.setCellValue((Integer) value);
            } else if (value instanceof String) {
                cell.setCellValue((String) value);
            } else if (value instanceof Boolean) {
                cell.setCellValue((Boolean) value);
            } else if (value instanceof Date) {
                DateTimeFormatter sourceFormatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy",
                        Locale.ENGLISH);
                DateTimeFormatter targetFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(value.toString(), sourceFormatter);
                String convertedTime = dateTime.format(targetFormatter);
                cell.setCellValue(convertedTime);

            } else if (value instanceof Double) {
                cell.setCellValue(value.toString());
            } else {
                // 处理其他类型的值
            }
        } catch (Exception e) {
            // 处理异常情况
            e.printStackTrace();
        }
    }

}