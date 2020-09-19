package sample.test;

import org.json.JSONArray;
import sample.dao.PokemonCardDAO;
import sample.model.PokemonCard;
import sample.model.PokemonCardList;
import sample.parsers.PokemonCardListParser;
import sample.parsers.PokemonCardRarityParser;

import java.io.*;

/**
 * <h1>Class FillTable</h1>
 * <h3>Made for test</h3>
 * Originally made to test the PokemonCardDAO and to fill the SQL database with some json files.
 * May be kept in the final product, but it is not required.
 *
 * @author Nathan Brito da Silva - 17.00531-0
 * @version 1.0
 * @since 2020-09-07
 */
public class FillTable {

    public static void main(String[] args) {
        String[] listoffiles = {"base1", "base2", "base3", "base4", "base5", "gym1", "gym2", "neo1", "neo2"};
        PokemonCardDAO cardDAO = new PokemonCardDAO();
        /*
        for (PokemonCard card: cardDAO.getAll()) {
            cardDAO.delete(card);
        }
         */
        try{
            for (String filename: listoffiles) {
                PokemonCardList cardList = PokemonCardListParser.fromJson(lerArquivo("jsontxtfiles/"+ filename +".txt"));
                System.out.println(cardDAO.getTableName());
                for (PokemonCard card: cardList.getCards()) {
                    try{
                        System.out.println(card.getName());
                        cardDAO.create(card);
                    } catch (Exception exception){
                        exception.printStackTrace();
                    }

                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Read file and extract the json from it.
     * @param nomeArquivo Filename. String
     * @return JSONArray
     */
    private static JSONArray lerArquivo(String nomeArquivo) {
        JSONArray json = null;
        File file = new File(nomeArquivo);
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            json = new JSONArray (bufferedReader.readLine());
            bufferedReader.close();
            fileReader.close();

        }catch (Exception exception){
            System.out.println("Algo deu errado!");
            exception.printStackTrace();
        }
        return json;
    }

    /**
     * Write json data in a file.
     * @param nomeArquivo Name of the file. String
     * @param json Json data to be written. JSONArray
     */
    private static void escreverArquivo(String nomeArquivo, JSONArray json) {
        File file = new File(nomeArquivo);
        try{

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("" + json);
            bufferedWriter.close();
            fileWriter.close();

        }catch(Exception exception){
            System.out.println("Algo deu errado!");
            exception.printStackTrace();
        }
    }

}
