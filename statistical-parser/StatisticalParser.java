import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class StatisticalParser {
    //Main method
    public static void main(String[] args) {
        String fileName = "Salty Snack Market Data Fall 2025-1.xlsx";
        ArrayList<Double> dollarsData  = getDollarsData(fileName);

        //Data harus disort, sehingga dapat mencari quartile
        Collections.sort(dollarsData);

        System.out.println("Jumlah data valid: "+dollarsData.size());
        //Memanggil method untuk mencari rata-rata
        Double mean = Mean(dollarsData);
        System.out.printf("Mean: %.2f\n", mean);

        //Memanggil method untuk mencari median (kuartil 2)
        Double median = quartil(dollarsData,2);
        System.out.printf("Median: %.2f\n",median);

        //Memanggil method untuk mencari standar deviasi
        Double standarDeviasi = standardDeviation(dollarsData,mean);
        System.out.printf("s: %.2f\n",standarDeviasi);

        //Karena sudah disort, minimum = index terdepan
        System.out.printf("Min: %.2f\n",dollarsData.get(0));

        //Memanggil method untuk mencari kuartil 1
        Double q1 = quartil(dollarsData,1);
        System.out.printf("Q1: %.2f\n",q1);

        //Memanggil method untuk mencari kuartil 3
        Double q3 = quartil(dollarsData,3);
        System.out.printf("Q3: %.2f\n",q3);

        //Karena sudah disort, maximum = index terbelakang (dollarsData.size()-1)
        System.out.printf("Max: %.2f\n",dollarsData.get(dollarsData.size()-1));

        //Memanggil method untuk mencari interquartile range
        Double iqr = interquartileRange(q1,q3);
        System.out.printf("IQR: %.2f\n",iqr);

        //Memanggil method untuk mencari batas bawah dan batas atas
        Double batasBwh = batasBawah(q1,iqr);
        Double batasAts = batasAtas(q3,iqr);

        //Memanggil method untuk mencari dan output outlier
        outliers(dollarsData,batasBwh,batasAts);




    }

    //Method untuk mencari outlier (jika lebih angka lebih kecil dari batas bawah atau lebih besar dari batas atas)
    public static void  outliers(ArrayList<Double> dollarsData,Double batasBawah,Double batasAtas){
        //counter untuk menyimpan jumlah outlier
        int counter =0;
        //Array untuk menyimpan 10 data outlier pertama
        Double[] outlier = new Double[10];
        for(int i=0;i<dollarsData.size();i++){
            //Kondisi outlier
            if(dollarsData.get(i)<batasBawah||dollarsData.get(i)>batasAtas){
                //Jika belum ada 10, ditambahkan ke array
                if(counter<=9){
                    outlier[counter]=dollarsData.get(i);
                }
                counter++;
            }
        }
        //Mengeluarkan jumlah outlier
        System.out.println("Jumlah outlier: "+counter);

        int counters =1;
        //Menggunakan enhanced for loop untuk langusng mendapatkan nilai outlier
        for(Double outlierr: outlier){
            if(outlierr!=null) {
                System.out.printf("Outlier %d: %.2f\n", counters, outlierr);
                counters++;
            }
        }
    }

    //Method untuk mencari batas atas dari interquartile dan q3
    public static Double batasAtas (Double q3,Double iqr){
        //Rumus batas atas = q3 + 1.5 * iqr
        Double batasAtass = q3 + 1.5 * iqr;
        return batasAtass;
    }

    //Method untuk mencari batas bawah dari interquartile dan q1
    public static Double batasBawah(Double q1, Double iqr){
        //Rumus batas bawah = q1 - 1.5 * iqr
        Double batasBawahs = q1 - 1.5*iqr;
        return batasBawahs;
    }

    //Method untuk menghitung interquartileRange
    public static Double interquartileRange(Double q1, Double q3){
        //Rumus interquartile = q3-q1
        return q3-q1;
    }

    //Method untuk mencari standar deviasi
    public static Double standardDeviation(ArrayList<Double> list, Double mean){
        double result =0;
        //Menjumlahkan setiap perbedaan dari xi dan mean, kemudian dikuadratkan
        for(int i=0;i<list.size();i++){
            result+= (list.get(i)-mean)*(list.get(i)-mean);
        }
        //Dibagi dengan jumlah data
        result=result/list.size();
        //Diakarin
        return Math.sqrt(result);
    }

    //Method untuk mencari kuartil, parameter ke-2 menunjukan kuartil ke berapa, median = Q2
    public static double quartil(ArrayList<Double> list,int quartil) {
        int n = list.size();
        //rumus posisi kuartil
        double index = (quartil*(n-1))/4.0;

        int indexAtas = (int) Math.ceil(index);
        int indexBawah = (int) Math.floor (index);

        //Jika indexAtas dan indexBawah sama artinya kuartilnya pas pada index tersebut dan tidak usah dihitung lagi
        if(indexBawah == indexAtas){
            return list.get(indexBawah);
        }

        //Jika indexnya tidak sama, harus dilakukan kalkulasi menggunakan rumus interpolasi linear
        double sisaDesimal = index-indexBawah;
        return list.get(indexBawah)+ sisaDesimal*(list.get(indexAtas)-list.get(indexBawah));


    }

    //Method untuk mencari rata-rata
    public static double Mean(ArrayList<Double> list){
        double sum=0;
        //Mencari total jumlah semua data
        for(Double d:list){
            sum+=d;
        }
        //Dibagi dengan jumlah data
        return sum/list.size();
    }

    //Method untuk membaca file excel
    public static ArrayList<Double> getDollarsData(String filePath){
        //Struktur data ArrayList untuk menyimpan data dollars
        ArrayList<Double> dollarsData = new ArrayList<>();

        //Mengambil file untuk dibaca
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             //Workbook excel
             Workbook workbook = new XSSFWorkbook(fis)) {
            //Mengambil sheet dari worksheet excel
            Sheet sheet = workbook.getSheetAt(0);
            //Instansiasi index kolom untuk dollar, -1 untuk menandakan bahwa index belum ditemukan.
            int dollarsColumnIndex = -1;

            //enhance for loop, mengambil setiap baris dalam sheet
            for (Row row : sheet) {
                //Mencari posisi indeks kolom "Dollars" yang tepat
                if (dollarsColumnIndex == -1) {
                    //Untuk setiap sel dalam baris
                    for (Cell cell : row) {
                        //Jika tipe cell dalam String, maka diambil text dalam cell tersebut
                        if (cell.getCellType() == CellType.STRING) {
                            String headerText = cell.getStringCellValue().trim();
                            // Mencari kolom yang sama dengan Dollars, jika ketemu maka indexnya ketemu
                            if (headerText.equalsIgnoreCase("Dollars")) {
                                dollarsColumnIndex = cell.getColumnIndex();
                                break;
                            }
                        }
                    }
                    // Jika baris pertama sudah diperiksa tapi kolom tidak ketemu, hentikan program
                    if (dollarsColumnIndex == -1) {
                        System.err.println("Error: Kolom 'Dollars' tidak ditemukan di file Excel!");
                        break;
                    }
                    continue; // Lewati baris header agar tidak ikut dihitung sebagai data statistik
                }

                // Baris berikutnya: Mengambil data numerik berdasarkan indeks yang sudah ditemukan
                Cell cell = row.getCell(dollarsColumnIndex);

                // Abaikan data kosong (null atau blank)
                if (cell == null || cell.getCellType() == CellType.BLANK) {
                    continue;
                }
                //Jika data memang terisi maka ditambahkan ke arraylist
                if (cell.getCellType() == CellType.NUMERIC) {
                    dollarsData.add(cell.getNumericCellValue());
                }
            }
        } catch (IOException e) {
            System.err.println("Gagal membaca file: " + e.getMessage());
        }

        return dollarsData;

    }



}
