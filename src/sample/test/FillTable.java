package sample.test;

import org.json.JSONArray;
import sample.model.PokemonCard;
import sample.model.PokemonCardList;
import sample.parsers.PokemonCardListParser;

import java.io.*;

// Making a test class to both read Json and fill the database.
// Mostly to avoid doing it all manually. I know Json is not in the exercise list, so I'll probably remove it later
public class FillTable {
    public static void main(String[] args) {
        PokemonCardList cardList = PokemonCardListParser.fromJson(lerArquivo("base1.txt"));
        for (PokemonCard card: cardList.getCards()) {
            System.out.println(card.getName());

        }
    }

    // Yes yes, reusing from previous codes.
    private static JSONArray lerArquivo(String nomeArquivo) {
        JSONArray json = null;
        File file = new File(nomeArquivo);
        try{
            //Cria o fluxo de leitura
            FileReader fileReader = new FileReader(file);
            //Buffer de leitura
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            json = new JSONArray (bufferedReader.readLine());

            //Feche tudo ao terminar
            bufferedReader.close();
            fileReader.close();

        }catch (Exception exception){
            System.out.println("Algo deu errado!");
            exception.printStackTrace();
        }
        return json;
    }

    private static void escreverArquivo(String nomeArquivo, JSONArray json) {
        //Cria um arquivo
        File file = new File(nomeArquivo);
        try{

            //Cria uma conexão apra escrever no arquivo
            FileWriter fileWriter = new FileWriter(file);
            //Cria um buffer de writting
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            //Escrever algo no arquivo
            bufferedWriter.write("" + json);

            //Fecha o buffer e escreve no arquivo
            bufferedWriter.close();
            //fecha os demais fluxos
            fileWriter.close();

        }catch(Exception exception){
            System.out.println("Algo deu errado!");
            exception.printStackTrace();
        }
    }

}
