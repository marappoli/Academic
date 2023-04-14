package projetozumbi;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
public class Mundo {
    Random random = new Random();
    int Npessoas=103;
    int [][] map = new int[30][90];
    Pessoa[] pessoas = new Pessoa[Npessoas];
    
    int doente;
    int imune = 0;
    int saudavel = 0;
    int zumbi = 0;

    
    public boolean isHospital(int x,int y){
        if (((x>5 && y>5) && (x<10 && y<10)) || ((x>15 && y>15)&&(x<20 && y<20)) ||
           ((x>20 && y>25) && (x<25 && y<30))){
            return true;
        }
        return false;
    }
    public boolean isFrontier(int x,int y){
        if (x==0 || x==29 || y==0 || y==89){
            return true;
        }
        
        return false;
    }
    public void BuildFrontier(){
        for(int x=0;x<30;x++){
            for(int y=0;y<90;y++){
                if (x==0 || x==29 || y==0 || y==89){
                    map[x][y] = 1;
                }
            }
        }
    }
    public void BuildHospital(){
        for(int x=0;x<30;x++){
            for(int y=0;y<90;y++){
                if ( ((x>5 && y>5) && (x<10 && y<10)) || ((x>15 && y>15)&&(x<20 && y<20)) || 
                   ((x>20 && y>25) && (x<25 && y<30))){
                    map[x][y]=2;
                }
            }
        }
    }

    public void Default(){
        for(int x=0;x<30;x++){
            for(int y=0;y<90;y++){
                map[x][y]=0;
            }
        } 
        BuildFrontier();
        BuildHospital();
        for(int i=0;i<Npessoas;i++){
            int x=0,y=0;
            while(map[x][y]!=0){
                x = random.nextInt(27)+1;
                y = random.nextInt(87)+1;
            }
            if (map[x][y] == 0){
                if (i == Npessoas-1){
                    pessoas[i] = new PessoaDoente(x,y);
                    
                }
                else if (i == Npessoas-2){
                    pessoas[i] = new PessoaDoente(x,y);
                    
                }
                else if(i == Npessoas-3){
                    
                    pessoas[i] = new PessoaImune(x,y); 
                    
                }
                else{
                    pessoas[i] = new PessoaSaudavel(x,y);
                   
                }
            } 
        }
        for(int i=0;i<Npessoas;i++){
        if (pessoas[i]!=null && pessoas[i].getClass()==PessoaDoente.class){
                int xPessoaDoente=pessoas[i].getX();
                int yPessoaDoente=pessoas[i].getY();
                for(int j=0;j<Npessoas;j++){
                    if (pessoas[j]!=null && pessoas[j].getClass()==PessoaSaudavel.class){
                        int xPessoaSaudavel = pessoas[j].getX();
                        int yPessoaSaudavel = pessoas[j].getY();
                        if( ((xPessoaSaudavel==xPessoaDoente) && (yPessoaSaudavel==yPessoaDoente)) || 
                          ((xPessoaSaudavel==xPessoaDoente-1) && (yPessoaSaudavel==yPessoaDoente)) || 
                          ((xPessoaSaudavel==xPessoaDoente+1) && (yPessoaSaudavel==yPessoaDoente)) ||
                          ((xPessoaSaudavel==xPessoaDoente) && (yPessoaSaudavel==yPessoaDoente+1)) || 
                          ((xPessoaSaudavel==xPessoaDoente) && (yPessoaSaudavel==yPessoaDoente-1))){
                            int x=0, y=0;
                            x = random.nextInt(27)+1;
                            y = random.nextInt(87)+1;
                            if (map[x][y] == 0){
                              if (i == Npessoas-1){
                                 pessoas[i] = new PessoaDoente(x,y);
                    
                                }
                              else if (i == Npessoas-2){
                                 pessoas[i] = new PessoaDoente(x,y);
                    
                                }
                              else if(i == Npessoas-3){
                    
                                 pessoas[i] = new PessoaImune(x,y); 
                    
                                }
                              else{
                                 pessoas[i] = new PessoaSaudavel(x,y);
                   
                                }
                             } 
                           }
                        }
                    }
                }
             }
        for(int i=0;i<Npessoas;i++){
        if (pessoas[i]!=null && pessoas[i].getClass()==PessoaImune.class){
                int xPessoaImune=pessoas[i].getX();
                int yPessoaImune=pessoas[i].getY();
                for(int j=0;j<Npessoas;j++){
                    if (pessoas[j]!=null && pessoas[j].getClass()==PessoaSaudavel.class){
                        int xPessoaSaudavel = pessoas[j].getX();
                        int yPessoaSaudavel = pessoas[j].getY();
                        if( ((xPessoaSaudavel==xPessoaImune) && (yPessoaSaudavel==yPessoaImune)) || 
                          ((xPessoaSaudavel==xPessoaImune-1) && (yPessoaSaudavel==yPessoaImune)) || 
                          ((xPessoaSaudavel==xPessoaImune+1) && (yPessoaSaudavel==yPessoaImune)) ||
                          ((xPessoaSaudavel==xPessoaImune) && (yPessoaSaudavel==yPessoaImune+1)) || 
                          ((xPessoaSaudavel==xPessoaImune) && (yPessoaSaudavel==yPessoaImune-1))){
                            int x=0, y=0;
                            x = random.nextInt(27)+1;
                            y = random.nextInt(87)+1;
                            if (map[x][y] == 0){
                              if (i == Npessoas-1){
                                 pessoas[i] = new PessoaDoente(x,y);
                    
                                }
                              else if (i == Npessoas-2){
                                 pessoas[i] = new PessoaDoente(x,y);
                    
                                }
                              else if(i == Npessoas-3){
                    
                                 pessoas[i] = new PessoaImune(x,y); 
                    
                                }
                              else{
                                 pessoas[i] = new PessoaSaudavel(x,y);
                   
                                }
                             } 
                           }
                        }
                    }
                }
             }
        run();
    }
    public void run (){
        Timer clock = new Timer();
        clock.schedule(new TimerTask() {
            @Override
            public void run(){
                Run();
            }}, 0,800);
    }
    
    public void Run(){
        BuildHospital();
        BuildFrontier();
        for (int i = 0; i < Npessoas; i++){
            if (pessoas[i] == null){
                continue;
            }
            else{
                int x = pessoas[i].getX();
                int y = pessoas[i].getY();
                if(isFrontier(x,y)){
                    map[x][y] = 1;
                }
                else if(isHospital(x,y)){
                    map[x][y] = 2;
                }
                else{
                    map[x][y] = 0;
                }
                pessoas[i].move();
                map[pessoas[i].getX()][pessoas[i].getY()] = pessoas[i].getColor(); 
            }
        }
        for(int i=0;i<Npessoas;i++){
            if (pessoas[i]!=null && pessoas[i].getClass()==PessoaDoente.class){
                int xPessoaDoente=pessoas[i].getX();
                int yPessoaDoente=pessoas[i].getY();
                for(int j=0;j<Npessoas;j++){
                    if (pessoas[j]!=null && pessoas[j].getClass()==PessoaSaudavel.class){
                        int xPessoaSaudavel = pessoas[j].getX();
                        int yPessoaSaudavel = pessoas[j].getY();
                        if( ((xPessoaSaudavel==xPessoaDoente) && (yPessoaSaudavel==yPessoaDoente)) || 
                          ((xPessoaSaudavel==xPessoaDoente-1) && (yPessoaSaudavel==yPessoaDoente)) || 
                          ((xPessoaSaudavel==xPessoaDoente+1) && (yPessoaSaudavel==yPessoaDoente)) ||
                          ((xPessoaSaudavel==xPessoaDoente) && (yPessoaSaudavel==yPessoaDoente+1)) || 
                          ((xPessoaSaudavel==xPessoaDoente) && (yPessoaSaudavel==yPessoaDoente-1))){
                            if (isHospital(xPessoaSaudavel, yPessoaSaudavel)==false){
                                pessoas[j] = new PessoaDoente(xPessoaSaudavel,yPessoaSaudavel);
                                map[pessoas[i].getX()][pessoas[i].getY()]=3;
                            }

                        }
                    }
                } 
          }
            if (pessoas[i]!=null && pessoas[i].getClass()==PessoaImune.class){
                int xPessoaImune=pessoas[i].getX();
                int yPessoaImune=pessoas[i].getY();
                for(int j=0;j<Npessoas;j++){
                    if (pessoas[j]!=null && pessoas[j].getClass()==PessoaDoente.class){
                        int xPessoaDoente = pessoas[j].getX();
                        int yPessoaDoente = pessoas[j].getY();
                        if( ((xPessoaDoente==xPessoaImune) && (yPessoaDoente==yPessoaImune)) ||
                          ((xPessoaDoente==xPessoaImune-1) && (yPessoaDoente==yPessoaImune)) || 
                          ((xPessoaDoente==xPessoaImune+1) && (yPessoaDoente==yPessoaImune)) ||
                          ((xPessoaDoente==xPessoaImune) && (yPessoaDoente==yPessoaImune+1)) || 
                          ((xPessoaDoente==xPessoaImune) && (yPessoaDoente==yPessoaImune-1))){
                            if (isHospital(xPessoaDoente, yPessoaDoente)==false){
                                pessoas[j] = new PessoaImune(xPessoaDoente,yPessoaDoente);
                                map[pessoas[i].getX()][pessoas[i].getY()]=4;
                            }

                        }
                    }
                } 
          }
            if (pessoas[i]!=null && pessoas[i].getClass()==PessoaImune.class){
                int xPessoaImune=pessoas[i].getX();
                int yPessoaImune=pessoas[i].getY();
                for(int j=0;j<Npessoas;j++){
                    if (pessoas[j]!=null && pessoas[j].getClass()==PessoaSaudavel.class){
                        int xPessoaSaudavel = pessoas[j].getX();
                        int yPessoaSaudavel = pessoas[j].getY();
                        if( ((xPessoaSaudavel==xPessoaImune) && (yPessoaSaudavel==yPessoaImune)) ||
                          ((xPessoaSaudavel==xPessoaImune-1) && (yPessoaSaudavel==yPessoaImune)) || 
                          ((xPessoaSaudavel==xPessoaImune+1) && (yPessoaSaudavel==yPessoaImune)) ||
                          ((xPessoaSaudavel==xPessoaImune) && (yPessoaSaudavel==yPessoaImune+1)) || 
                          ((xPessoaSaudavel==xPessoaImune) && (yPessoaSaudavel==yPessoaImune-1))){
                            if (isHospital(xPessoaSaudavel, yPessoaSaudavel)==false){
                                pessoas[j] = new PessoaImune(xPessoaSaudavel,yPessoaSaudavel);
                                map[pessoas[i].getX()][pessoas[i].getY()]=4;
                            }

                        }
                    }
                } 
          }
            if (pessoas[i]!=null && pessoas[i].getClass()==Zumbi.class){
                int xZumbi=pessoas[i].getX();
                int yZumbi=pessoas[i].getY();
                for(int j=0;j<Npessoas;j++){
                    if (pessoas[j]!=null && pessoas[j].getClass()==PessoaSaudavel.class){
                        int xPessoaSaudavel = pessoas[j].getX();
                        int yPessoaSaudavel = pessoas[j].getY();
                        if( ((xPessoaSaudavel==xZumbi) && (yPessoaSaudavel==yZumbi)) ||
                          ((xPessoaSaudavel==xZumbi-1) && (yPessoaSaudavel==yZumbi)) || 
                          ((xPessoaSaudavel==xZumbi+1) && (yPessoaSaudavel==yZumbi)) ||
                          ((xPessoaSaudavel==xZumbi) && (yPessoaSaudavel==yZumbi+1)) || 
                          ((xPessoaSaudavel==xZumbi) && (yPessoaSaudavel==yZumbi-1))){
                            pessoas[j] = new Zumbi(xPessoaSaudavel,yPessoaSaudavel);
                            map[pessoas[i].getX()][pessoas[i].getY()]=5;
                            

                        }
                    }
                } 
          }
        }
        for(int i=0;i<Npessoas;i++){
            if (pessoas[i]!=null && pessoas[i].getClass()==PessoaDoente.class 
                    &&isHospital(pessoas[i].getX(),pessoas[i].getY())){
                pessoas[i]=new PessoaSaudavel(pessoas[i].getX(),pessoas[i].getY());
            }
        }
        for (int i=0;i<Npessoas;i++){
            if(pessoas[i]!=null && pessoas[i].getClass()==PessoaDoente.class && pessoas[i].getLife()==0){
                if (isFrontier(pessoas[i].getX(), pessoas[i].getY())){
                    map[pessoas[i].getX()][pessoas[i].getY()]=1;
                }
                else if( isHospital(pessoas[i].getX(), pessoas[i].getY())){
                    map[pessoas[i].getX()][pessoas[i].getY()]=2;
                }
                else{
                    map[pessoas[i].getX()][pessoas[i].getY()]=0;
                }
                pessoas[i]= new Zumbi(pessoas[i].getX(), pessoas[i].getY());
                
            }
        }
        
        doente = 0;
        saudavel = 0;
        zumbi = 0;
        imune = 0;
        for (int i=0;i<Npessoas;i++){
            if(pessoas[i]!=null && pessoas[i].getClass()==Zumbi.class){
                zumbi++;
            }
            else if(pessoas[i]!=null && pessoas[i].getClass()==PessoaDoente.class){
                doente++;
            }
            else if(pessoas[i]!=null && pessoas[i].getClass()==PessoaSaudavel.class){
                saudavel++;
            }
            else if(pessoas[i]!=null && pessoas[i].getClass()==PessoaImune.class){
                imune++;
            }
        }
        if (saudavel == 0 ){
            System.exit(1);
        }
        DesenhaMundo();
    }
    public void DesenhaMundo(){
        for(int x=0;x<30;x++){
            for(int y=0;y<90;y++){
                switch(map[x][y]){
                    case 0:
                        System.out.print(" ");
                        break;
                    case 1:
                        System.out.print("\033[47m \033[0m");
                        break;
                    case 2:
                        System.out.print("\033[45m \033[0m");
                        break;
                    case 3:
                        System.out.print("\033[43m \033[0m");
                        break;
                    case 4:
                        System.out.print("\033[44m \033[0m");
                        break;
                    case 5:
                        System.out.print("\033[46m \033[0m");
                        break;
                    case 6:
                        System.out.print("\033[42m \033[0m");
                        break;
                }
            }
            System.out.println("");
        }
        System.out.println("\n\n\n");
        System.out.println("Doentes (amarelos): "+doente+"\nSaudaveis(azuis escuros): "+saudavel+
        "\nZumbi (verdes): "+zumbi+"\nImune (azuis claros): "+imune);
    }  
}
