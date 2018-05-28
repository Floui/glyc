
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

              // write your code here
                CSVReader seznam = new CSVReader(new FileReader("resources/seznam.csv"), ';');
                CSVReader konGly = new CSVReader(new FileReader("resources/DataKonverzeGlyconect.csv"), ';');
                CSVReader konUni = new CSVReader(new FileReader("resources/DataKonverzeUnicarb.csv"), ';');
                CSVReader toucan = new CSVReader(new FileReader("resources/glytoucan.csv"), ';');
                CSVReader metaGly = new CSVReader(new FileReader("resources/DataMetaGlyconect.csv"), ';');
                CSVReader metaUni = new CSVReader(new FileReader("resources/DataMetaUnicarb.csv"), ';');
                CSVReader unicarb = new CSVReader(new FileReader("resources/unicarb.csv"), ';');
                String[] newLine;
                List<String[]> seznamList = seznam.readAll(); /*idGly, GlycoCT accnum*/
                List<String[]> konGlyList = konGly.readAll(); /*idGly, Inchi, Inchikey smiles*/
                List<String[]> konUniList = konUni.readAll();/*iduni, Inchi, Inchikey smiles*/
                List<String[]> toucanList = toucan.readAll(); /*accnum, entryURL, toucanCID, url*/
                List<String[]> metaGlyList = metaGly.readAll(); /*metaGlyCID idgly conectionGly, identconGly */
                List<String[]> metaUniList = metaUni.readAll(); /*metaUniCID iduni conectionUni, identconUni */
                List<String[]> unicarbList = unicarb.readAll();/*id_from_UnicarbKB;GlycoCT;CSDB;SMILES;InChI;InChIKey;Pubchem;Urceno;Výsledek */

                List ids = new LinkedList();
        CSVWriter glytoucanmap = new CSVWriter(new FileWriter("resources/glytoucanmap.csv"));
                for (String[] unic : unicarbList) {
                    for (String[] entry : konGlyList) {
                        if (unic[4].equals(entry[1])) {
                            System.out.println(unic[0] + " " + entry[0]);
                            String[] k = new String[]{unic[0], entry[0]};
                            ids.add(k);
                        }
                    }

                }
                List glytoucanlist = new LinkedList();
                for (var gly: seznamList){
                    for (var e:toucanList){
                        if (gly[2].equals(e[0])){
                            System.out.println(gly[0] +" " + gly[2] + "," + e[3]);
                            glytoucanlist.add(gly[0] + ";" + gly[2] + ";" + e[3]);

                        }
                    }
                }
                System.out.println(ids.size());
                for(var id :ids){

                }
            }
        }

