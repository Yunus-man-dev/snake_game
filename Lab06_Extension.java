import java.util.Random;
import java.util.Scanner;

public class Lab06_Extension {
        static int snakeX=6;
    static int snakeY=3;
    static int fruitX;
    static int fruitY;

    static int poison1X=-1;
    static int poison1Y=-1;

    static int poison2X=-1;
    static int poison2Y=-1;

    static int poison3X=-1;
    static int poison3Y=-1;

    static int poison4X=-1;
    static int poison4Y=-1;

    static int poison5X=-1;
    static int poison5Y=-1;

    static int score=0;
    static boolean end=false;
    static int movesSinceFoodSpawn=0;
    public static void moveSnake(String str){

        if(str.equalsIgnoreCase("s"))
        snakeY--;
        if(str.equalsIgnoreCase("W"))
        snakeY++;
        if(str.equalsIgnoreCase("A"))
        snakeX--;
        if(str.equalsIgnoreCase("d"))
        snakeX++;
        movesSinceFoodSpawn++;

    }
    public static void generateFoodandPoison(){
        Random gen=new Random();
        fruitX=gen.nextInt(8)+1;
        fruitY=gen.nextInt(7)+2;
       int numbOfPoison=gen.nextInt(3,6);

       if(numbOfPoison==3){
        poison1X=gen.nextInt(1,8);
        poison1Y=gen.nextInt(1,8);
        poison2X=gen.nextInt(1,8);
        poison2Y=gen.nextInt(1,8);
        poison3X=gen.nextInt(1,8);
        poison3Y=gen.nextInt(1,8);
       }

       else if(numbOfPoison==4){
        poison1X=gen.nextInt(1,8);
        poison1Y=gen.nextInt(1,8);
        poison2X=gen.nextInt(1,8);
        poison2Y=gen.nextInt(1,8);
        poison3X=gen.nextInt(1,8);
        poison3Y=gen.nextInt(1,8);
        poison4X=gen.nextInt(1,8);
        poison4Y=gen.nextInt(1,8);
       }

       else{
        poison1X=gen.nextInt(1,8);
        poison1Y=gen.nextInt(1,8);
        poison2X=gen.nextInt(1,8);
        poison2Y=gen.nextInt(1,8);
        poison3X=gen.nextInt(1,8);
        poison3Y=gen.nextInt(1,8);
        poison4X=gen.nextInt(1,8);
        poison4Y=gen.nextInt(1,8);
        poison5X=gen.nextInt(1,8);
        poison5Y=gen.nextInt(1,8);
       }

        if(fruitX==snakeX&&fruitY==snakeY){
            fruitX=gen.nextInt(8)+1;
            fruitY=gen.nextInt(7)+2;
        }
        

        while((fruitX==poison1X&&fruitY==poison1Y)||(fruitX==poison2X&&fruitY==poison2Y)||
        (fruitX==poison3X&&fruitY==poison3Y)||(fruitX==poison4X&&fruitY==poison4Y)||(fruitX==poison5X&&fruitY==poison5Y)){
            fruitX=gen.nextInt(8)+1;
            fruitY=gen.nextInt(8)+1;
        }
        
    }
    public static void checkFood(){
        
        if(snakeX==fruitX&&snakeY==fruitY){
            System.out.println("Yum! Snake ate the food!");
            generateFoodandPoison();
            score++;
            movesSinceFoodSpawn=0;
        }
        
    }
    public static void teleportFood(){
        if (score >= 5 && movesSinceFoodSpawn == 6)
            generateFoodandPoison();
    }


    public static void checkPoison(){

        if( (snakeX==poison1X&&snakeY==poison1Y)||(snakeX==poison2X&&snakeY==poison2Y)||
            (snakeX==poison3X&&snakeY==poison3Y)||(snakeX==poison4X&&snakeY==poison4Y)||(snakeX==poison5X&&snakeY==poison5Y)){
             end=true;
             System.out.println("Game over! Snake hit the poison ");
        }   
    }


    public static void isGameOver(){
        if(snakeX==9||snakeX==0||snakeY==1||snakeY==9){
            System.out.println("Game over! Snake hit the wall ");
            end=true;
        }
        
    }
    

    public static void printGrind(){
        String design="";
       for(int i=10; i>0; i--){
            for(int k=0; k<10; k++){
                if(k==snakeX&&i==snakeY)
                design=design+"S ";
                else if(k==fruitX&&i==fruitY)
                design=design+"O ";
                else if((k==poison1X&&i==poison1Y)||(k==poison2X&&i==poison2Y)||(k==poison3X&&i==poison3Y)||(k==poison4X&&i==poison4Y)||(k==poison5X&&i==poison5Y))
                design=design+"X ";
                else
                design=design+". ";
                

            }
           design=design+"\n";
       }
       System.out.println(design);
    } 


    
    public static void main(String[] args) {
        
      Scanner in=new Scanner(System.in);
      generateFoodandPoison();
      System.out.printf("Welcome to Hungry Snake!%nUse W (Up), A (Left), S (Down), D (Right) to move.%n");
      printGrind();
      while(!end){
        System.out.print("Move: ");
        String direction=in.next();
        // if(direction.equalsIgnoreCase("W")||direction.equalsIgnoreCase("s")||direction.equalsIgnoreCase("d")||direction.equalsIgnoreCase("a"))
        moveSnake(direction);
        
        System.out.printf("Snake x coordination: %d%nSnake y coordination: %d%n",snakeX,snakeY);
        
        checkFood();
        isGameOver();
        checkPoison();
        System.out.printf("SCORE: %d%n",score);
       
        if(!end){
           
            teleportFood() ;
            printGrind();
        }
       
      }
      in.close();
       
      
    }
}
