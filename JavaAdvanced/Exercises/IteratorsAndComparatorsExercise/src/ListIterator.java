import java.util.Iterator;
import java.util.List;

public class ListIterator implements Iterable<String> {
    private List<String> data;// списък с данни за обхождане
    private int index; // текущ индекс

    public ListIterator(List<String> data) {
        this.data = data;
        if (this.data.size() != 0) {
            this.index = 0;
        } else {
            this.index = -1;
        }
    }

    public boolean move (){
        if (this.index<this.data.size()-1){
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext(){
//        if(this.index< this.data.size()-1){
//            return true;
//        }
//        return false;

        return this.index<this.data.size()-1;
    }

    public void print() throws Exception {
        if(!this.data.isEmpty()){
            System.out.println(this.data.get(this.index));
        }else{
//            throw new Exception("Invalid Operation!");
            System.out.println("Invalid Operation!");
        }
    }

    public void printAll(){
        for (String string: this.data) {
            System.out.print(string+" ");
        }
        System.out.println();
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return  this.index<data.size()-1;
            }

            @Override
            public String next() {
                return data.get(index++);
            }
        };
    }
}
