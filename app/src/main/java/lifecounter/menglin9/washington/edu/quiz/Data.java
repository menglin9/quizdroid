package lifecounter.menglin9.washington.edu.quiz;

/**
 * Created by Menglin on 4/26/15.
 */
import android.app.Application;

public class Data extends Application{
    private int math;
    private int id;
    private String record;

    public int getMath() {
        return this.math;
    }

    public void setMath(int a) {
        this.math = a;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int b) {
        this.id = b;
    }

    public String getRecord() {
        return this.record;
    }

    public void setRecord(String s) {
        this.record = s;
    }

    @Override
    public void onCreate(){
        math = 0;
        id = 0;
        super.onCreate();
    }
}
