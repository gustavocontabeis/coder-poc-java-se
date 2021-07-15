package br.com.coder.testesjavase.ps;


import java.io.*;

public class JavaRunCommand {

    public static void main(String args[]) {
        long start = System.currentTimeMillis();
        System.out.println("::::::::::::::::::::::::::::::::::");
        String s = null;
        int exitCode = 0;

        try {

            // run the Unix "ps -ef" command
            // using the Runtime exec method:
            //Process p = Runtime.getRuntime().exec("ps -ef");
            Process p = Runtime.getRuntime().exec("jps -v");

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read any errors from the attempted command
            System.out.println("Aqui é a saída do comando em caso de erro:\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
            // read the output from the command
            System.out.println("Aqui é a saída do comando:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println("-> "+s);
                
                if(s.contains("-D[Standalone]")){
                    System.out.println("::::::::::::::::::::::::::::::::::");
                    String[] split = s.split(" ");
                    if(split.length>0){
                        System.out.println("Encerrando o processo: "+split[0]);
                        Runtime.getRuntime().exec("kill -9 "+split[0]);
                    }
                    System.out.println("::::::::::::::::::::::::::::::::::");
                }
                
            }
        } catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            exitCode = 1;
        }
        System.out.println("::::::::::::::::::::::::::::::::::");
        System.out.println((System.currentTimeMillis() - start)/1000);
        System.exit(exitCode);
    }
}
