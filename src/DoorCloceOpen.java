public class DoorCloceOpen {
    public static void main(String[] args) {
        int students  = 100;
        int closet = 100;
        boolean[] doors = new boolean[closet+1];
        for(int i=1;i<students;i++){
            int start = i;
            while(start <= closet){
                if(doors[start]){
                    doors[start] = false;
                }else {
                    doors[start] = true;
                }
                start += start;
            }
        }
        for(int i =1 ;i< doors.length;i++){
            if(doors[i]){
                System.out.println(i +"---open");
            }else {
                System.out.println(i+"---closed");
            }
        }
    }
}
//9:53 to 10:06 -- 15 mins