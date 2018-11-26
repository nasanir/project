package pers.nasanir.funny.nospider.main;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import pers.nasanir.funny.nospider.model.FakeLoginMd;
import pers.nasanir.funny.nospider.model.FakeUserMd;
import pers.nasanir.funny.nospider.tools.lotofLogin.LotsOfLogin;
import pers.nasanir.funny.nospider.tools.readFile.ReadTextLine;
import pers.nasanir.funny.nospider.web.Spider;

import java.io.IOException;
import java.util.ArrayList;

public class StartKnit {
    public static void main(String[] args) {
        ArrayList<FakeUserMd> fakeUserMds=new ArrayList<FakeUserMd>();



        try {
            ReadTextLine readTextLine=new ReadTextLine();
            fakeUserMds=readTextLine.readUserByDf("D://maximouser.txt","maxadmin",120);
            LotsOfLogin lotsOfLogin=new LotsOfLogin("http://192.168.11.100:9395/maximo");
            lotsOfLogin.start(fakeUserMds);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
