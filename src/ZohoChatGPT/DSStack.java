package ZohoChatGPT;

public class DSStack {
    int[] arr;
    int top;
    int size;

    public DSStack(int size) {
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }

    public void  push(int num){
        top++;
        arr[top] = num;
        System.out.println("pushing "+num);
    }

    public int isEmpty(){
        if(top < 0){
            return -1;
        }
        else return 1;
    }

    public int peek(){
        if(top == -1){
            return 0;
        }
        System.out.println("peeking "+ arr[top]);
        return arr[top];
    }

    public int  pop(){
        System.out.println("popping "+arr[top]);
        int num = top;
        top--;
        return  num;
    }
}
