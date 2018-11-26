package pers.nasanir.funny.nospider.tools.readFile;

import pers.nasanir.funny.nospider.model.FakeUserMd;
import sun.nio.cs.FastCharsetProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadTextLine {

  public ArrayList<FakeUserMd> readUserByDf(String url,String password,int num) throws IOException {
      ArrayList<FakeUserMd> fakeUserMds=new ArrayList<FakeUserMd>();
      File file=new File(url);
      FileInputStream fis = new FileInputStream(file);

      BufferedReader br = new BufferedReader(new InputStreamReader(fis));

      String line = null;
      for(int i=0;i<num&&(line = br.readLine()) != null;i++){
          FakeUserMd fakeUserMd=new FakeUserMd();
          fakeUserMd.setUsername(line);
          fakeUserMd.setPassword(password);
          fakeUserMds.add(fakeUserMd);
      }
      br.close();

      return fakeUserMds;
  }
}
