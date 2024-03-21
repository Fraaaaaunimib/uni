import java.util.concurrent.*;

class SumTask extends RecursiveTask<Double> {
	final int seqThreshold = 500;
	double[] data;
	int start, end;

	SumTask(double[] data, int start, int end)
	{
		this.data = data; this.start = start; this.end = end;
	}

	@Override
	protected Double compute() // method the thread has to execute
	{
		double sum = 0;
		if ((end - start) < seqThreshold) {
			for (int i = start; i < end; i++) sum += data[i]; 
      System.out.println("Leaf Task");
      //albero di chiamate a thread - fin quando gli elementi da sommare non sono minori di threshold
		}
		else {
			int middle = (start + end) / 2;

			SumTask subtaskA = new SumTask(data, start, middle);
			SumTask subtaskB = new SumTask(data, middle, end);

			subtaskA.fork(); 
      System.out.println("Forking Task A: start " + start + " end " + middle);
			subtaskB.fork();
      System.out.println("Forking Task B: start " + middle + " end " + end);
      
			sum += subtaskA.join() + subtaskB.join();
      System.out.println("Joining Tasks sum: " + sum);
		}
		return sum;
	}
}

class Summation implements Callable<Integer>{
    private int upper;
    public Summation(int u){ this.upper = u; }

    public Integer call() {
        System.out.println("Thread started in Callable");
        int sum = 0;
        for (int i = 0; i <= upper; i++) { sum+=i;}
        return Integer.valueOf(sum);
    }
}

class threadTest implements Runnable {
    private Thread t;
    private String thrName;

    public threadTest(String name){ //costruttore per impostare il nome
        thrName = name;
        System.out.println("Creato: " + thrName); //stampato dal main

    }

    public void run() { //alternanza dai thread
        System.out.println(">>   Running: " + thrName);
        try {
            for (int i = 2; i > 0; i--){
                System.out.print("Thread: " + thrName + ", " + i + " // ");
                int sleep = 5000; System.out.println("[ZZZ] I'm sleeping for " + sleep + "ms");
                Thread.sleep(sleep); //esegue un sleep di 50ms
                //i thread sono sottoposti a timeslice - senza lo sleep vengono switchati comunque
            }
        } catch (InterruptedException e) {
            System.out.println(thrName + " interrotto"); //interrompe il thread quando va in exception
        }
        System.out.println("Thread " + thrName + " uscito"); //finiscono i thread
    }

    public void start() { //metodo eseguito quando il thread parte
        System.out.println("   Starting: " + thrName);
        if (t == null) {
            t = new Thread(this, thrName);
            t.start();
            System.out.println("[Thread object test] " + t.toString());
        }
    }
}

class TestThread {
    public static void main(String args[]) {
        threadTest R1 = new threadTest("Thread-1");
        R1.start();

        threadTest R2 = new threadTest("Thread-2");
        R2.start();

        //test callable
        System.out.println();
        System.out.println("Callable test - thread pools");

        ExecutorService pool = Executors.newSingleThreadExecutor();
        Future<Integer> result = pool.submit(new Summation(10));
        try {
            System.out.println("Callable result: " + result.get());
        } catch (InterruptedException | ExecutionException ie) {}
        pool.shutdown();
        System.out.println("Exiting from the pool...");
        //da notare l'esecuzione concorrenziale - questo viene eseguito addirittura prima degli altri thread

        //test forkjoinpool
        int SIZE = 5;
        System.out.println();
        System.out.println("ForkJoinPool test");
        ForkJoinPool fjp = new ForkJoinPool(4);
        double[] nums = new double[5000];
        for (int i = 0; i < nums.length; i++) nums[i] = (double)(((i%2) == 0) ? i : -1); //effettuare la somma di un array
        SumTask task = new SumTask(nums, 0, nums.length); //si interrompe a volta per il quanto di tempo
        double summation = fjp.invoke(task);
        System.out.println("Summation " + summation);

    }
}