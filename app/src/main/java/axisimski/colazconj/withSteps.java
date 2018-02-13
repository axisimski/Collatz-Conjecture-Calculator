package axisimski.colazconj;

/**
 * Created by Alex on 2/12/2018.
 */

public class withSteps {

    long  x=0;
    long  s=0;
    long  z=0;
    StringBuilder Sequence = new StringBuilder();
    StringBuilder maxSequence = new StringBuilder();
    int i=0;
    long comp=100000000000L;
    long max=z;
    int maxStep=0;

    protected  void execute(){
        if(MainActivity.input.getText().toString().equals("")) {
            MainActivity.input.setError("Please enter a whole positive number between 1 and 100,000,000,000");
            return;
        }

        else {

            z=Long.valueOf(MainActivity.input.getText().toString());

            if(z<1||z>comp){
                MainActivity.input.setError("Please enter a whole positive number between 1 and 100,000,000,000");
                return;
            }
            else if(z==1){
                Sequence.append("You've reached 1 in 0 steps");
                MainActivity.output.setText(Sequence);
            }
            else
            {
                do {
                    i++;

                    if(z>max){
                        max=z;
                        maxStep=i-1;
                    }

                    if (z % 2 == 0) {
                        z = z / 2;
                    }

                    else{
                        z = z * 3;
                        z++;
                    }

                    Sequence.append("Step " + Integer.toString(i) + ": =  " + Long.toString(z) + "\n");

                } while (z != 1);

                maxSequence.append("Total steps: "+Integer.toString(i)+"\nMax value: " +
                        Long.toString(max)+"\n"+"at step number "+Integer.toString(maxStep)+"\n\n"+Sequence);

                MainActivity.output.setText(maxSequence);
            }

        }
    }

}