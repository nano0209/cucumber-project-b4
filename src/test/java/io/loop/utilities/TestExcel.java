package io.loop.utilities;

public class TestExcel {

    public static void main(String[] args) {
         ExcelUtils excelUtils = new ExcelUtils("C:\\Users\\naima\\IdeaProjects\\cucumber-project-b4\\src\\test\\resources\\Book2.xlsx", "Sheet1");

        System.out.println("excelUtils.getCellData(1, 1 = " + excelUtils.getCellData(0, 0));

        excelUtils.setCellData("nadir is hungry", 3, 5);
    }
}
