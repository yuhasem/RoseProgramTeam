package ppg.biridian;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

     public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int row = in.nextInt();
           int col = in.nextInt();
           
           char[][] grid = new char[row][col];
           int[][] distance = new int[row][col];
           int eX = 0, eY = 0;
           for (int i=0; i<row; i++){
        	   String temp = in.next();
        	   for(int j=0; j<col; j++){
        		   grid[i][j] = temp.charAt(j);
        		   if(temp.charAt(j) == 'E'){
        			   eX = i;
        			   eY = j;
        		   }
        	   }
           }
           
           int trainers = 0;
           
           LinkedList<Point> nodes = new LinkedList<Point>();
           nodes.push(new Point(eX,eY));
           while (!nodes.isEmpty()){
        	   Point current = nodes.pop();
        	   int x = (int) current.getX();
        	   int y = (int) current.getY();
        	   int distanceThis = distance[x][y];
        	   if (grid[x][y] == 'S'){
        		   while(!nodes.isEmpty()){
        			   Point thisThang = nodes.pop();
        			   if (distance[(int) thisThang.getX()][(int) thisThang.getY()] <= distanceThis) {
        				   trainers += grid[(int) thisThang.getX()][(int) thisThang.getY()]-'0';
        			   }
        		   }
        		   break;
        	   }
        	   if ((x+1 < row) && (grid[x+1][y] != 'T' && grid[x+1][y] != 'E' && distance[x+1][y] == 0)){
        		   nodes.add(new Point(x+1,y));
        		   distance[x+1][y] = distanceThis+1;
        	   }
        	   if ((x-1 >= 0) && (grid[x-1][y] != 'T' && grid[x-1][y] != 'E' && distance[x-1][y] == 0)){
        		   nodes.add(new Point(x-1,y));
        		   distance[x-1][y] = distanceThis+1;
        	   }
        	   if ((y+1 < col) && (grid[x][y+1] != 'T' && grid[x][y+1] != 'E' && distance[x][y+1] == 0)){
        		   nodes.add(new Point(x,y+1));
        		   distance[x][y+1] = distanceThis+1;
        	   }
        	   if ((y-1 >= 0) && (grid[x][y-1] != 'T' && grid[x][y-1] != 'E' && distance[x][y-1] == 0)){
        		   nodes.add(new Point(x,y-1));
        		   distance[x][y-1] = distanceThis+1;
        	   }
    		   if (grid[x][y] != 'E') trainers += grid[x][y]-'0';
           }
           System.out.println(trainers);
     }

}