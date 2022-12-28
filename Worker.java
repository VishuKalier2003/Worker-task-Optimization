/* You have n tasks and m workers... Each task has strength requirement stored in tasks array with the i th task requiring task[i] strength to complete... The Strength of each Worker is stored in array workers with the j th worker having workers[j] strength... Ech worker can only be assigned to a single task and mus have strength greater than or equal to the task strength requirement...
 * Additionally you have x magical pills that will increase the worker's strength by p... You can decide which worker receives the magical pills, however you may give each worker at most one magical pill...
 * Return the maximum number of tasks that can be completed by the m workers...
  */
import java.util.Scanner;
import java.util.Vector;
import java.util.Collections;
public class Worker
{
    public int MaximumTaskCompleted(Vector<Integer> tasks, Vector<Integer> worker, int p, int bon)
    {
        int count = 0;
        for(int j = 0; j < worker.size(); j++)
            worker.set(j, worker.get(j)+bon);    // Updating the strength of worker by pills...
        Collections.sort(worker);        // Sorting method of vector class...
        System.out.println("The Strengthened workers : ");
        System.out.println(worker);
        int c = 0;
        for(int j = 0; j < p; j ++)   // Since we have p pills we will assign p tasks this time...
        {
            for(int k = 0; k < tasks.size(); k++)
            {
                if(worker.get(j) >= tasks.get(k) && c == 0) 
                {
                    count++;
                    c++;       // Allowing to remove one task per iteration...
                    tasks.removeElementAt(k);     // Removing that specific task as well...
                }
            }
            c = 0;
        }
        for(int j = 0; j < p; j++)
            worker.removeElementAt(j);        // Removing the workers that are now appointed...
        for(int j = 0; j < worker.size(); j++)
            worker.set(j, worker.get(j)-bon);       // Returning to the Original worker strength...
        System.out.println("Workers still not appointed : ");
        System.out.println(worker);
        System.out.println("Tasks still not given : ");
        System.out.println(tasks);
        for(int j = 0; j < worker.size(); j++)   // Here we will assign all possible tasks...
        {
            for(int k = 0; k < tasks.size(); k++)
            {
                if(worker.get(j) >= tasks.get(k) && c == 0) 
                {
                    count++;
                    c++;       // Allowing to remove one task per iteration...
                    tasks.removeElementAt(k);     // Removing that specific task as well...
                }
            }
            c = 0;
        }
        for(int j = 0; j < p; j++)
            worker.removeElementAt(j);        // Removing the workers that are now appointed...
        System.out.println("Workers still not appointed : ");
        System.out.println(worker);
        System.out.println("Tasks still not given : ");
        System.out.println(tasks);
        return count;                  // returning the number of tasks assigned...
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n, m, a, pills, bonus, complete;
        System.out.print("Enter the number of tasks : ");
        n = sc.nextInt();
        System.out.print("Enter the number of workers : ");
        m = sc.nextInt();
        Vector<Integer> task = new Vector<Integer>(n);        // Vectors of tasks created...
        Vector<Integer> workers = new Vector<Integer>(m);     // Vectors of workers created...
        for(int i = 0; i < n; i++)
        {
            System.out.print("Enter the "+(i+1)+" task : ");
            a = sc.nextInt();
            task.add(a);
        }
        System.out.println("The Tasks array is : ");
        for(int i =1; i <= n; i++)
            System.out.print(task.get(i-1)+", ");
        System.out.println();
        for(int i = 0; i < m; i++)
        {
            System.out.print("Enter the "+(i+1)+" worker strength : ");
            a = sc.nextInt();
            workers.add(a);
        }
        System.out.println("The Worker Strength array is : ");
        for(int i =1; i <= m; i++)
            System.out.print(workers.get(i-1)+", ");
        System.out.println();
        System.out.print("Enter the number of pills : ");
        pills = sc.nextInt();
        System.out.print("Enter the strength of the pill provided : ");
        bonus = sc.nextInt();
        Worker work = new Worker();         // object creation...
        complete = work.MaximumTaskCompleted(task, workers, pills, bonus);    // function call...
        System.out.println("The Maximum tasks completed are : "+complete);
        sc.close();
    }
}