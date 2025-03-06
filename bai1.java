import java.util.Scanner; 

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);  
    System.out.print("Nhap r:");

    Double r = input.nextDouble();
    System.out.println(r);

    Double hinhvuong=4*r*r;


    Double x,y;

    int C=0;
    int N=100000000;
    for (int i=0;i<N;i++){
        x= Math.random()*(2*r)-r;
        y= Math.random()*(2*r)-r;
        if ((x*x+y*y)<=r*r) C++;
    }
    Double tile= (double)C/N;
    Double hinhtron=tile*hinhvuong;
    Double pi=tile*4;
    System.out.println("dien tich hinh tron xap xi:"+hinhtron);
    System.out.println("pi xap xi:"+pi);
  }
}
