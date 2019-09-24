package DesignPatterns.BehaviouralDesignPattern;

public class StrategyPattern {
    public static void main(String[] args) {
        Context ct = new Context(new InsertionSort());
        int[] arr = new int[]{3,5,1,8,2,6};
        ct.arrange(arr);
        for(int i:arr){
            System.out.println("each undex : "+i );
        }
    }

}

interface Strategy{
    public void sort(int[] numbers);
}

class BubbleSort implements Strategy{

    @Override
    public void sort(int[] numbers) {
        System.out.println("sorting by bubble sort");
    }
}

class InsertionSort implements Strategy{

    @Override
    public void sort(int[] numbers) {
        int start = 0;
        int end = numbers.length;

        for(int i=1;i<end;i++){
            int temp = numbers[i];
            int j = i;
            while(j>0 && temp<numbers[j-1]){
                numbers[j]=numbers[j-1];
                j=j-1;
            }
            numbers[j]=temp;
        }
    }
}

class MergeSort implements Strategy{

    @Override
    public void sort(int[] numbers) {
        System.out.println("sorting by merge sort");
    }
}

class Context{
    private Strategy st;

    public Context(Strategy st) {
        this.st = st;
    }

    public void arrange(int[] input){
        st.sort(input);
    }
}

