package level1;
import java.util.*;
public class SnakeLadder {
	static class Edge
	{
		int src,dest;
		Edge(int  src,int dest)
		{
			this.src=src;
			this.dest=dest;
		}
	}
	
	static class Node
	{
		// stores number associated with graph node
		int ver,min_dist;
		Node (int ver,int min_dest)
		{
			this.ver=ver;
			this.min_dist=min_dest;
		}
	}
	List<List<Integer>>adjList=null;
	
	SnakeLadder(List<Edge>edges,int N)
	{
		adjList=new ArrayList<>();
		for(int i=0;i<N;i++)
		{
			adjList.add(new ArrayList<>());
		}
		
		for(Edge e:edges)
		{
			adjList.get(e.src).add(e.dest);
		}
	}
	
	static void bfs(SnakeLadder graph,int source,int N)
	{
		Queue<Node>queue=new ArrayDeque<>();
		boolean[]visited=new boolean[N+1];
		visited[source]=true;
		
		Node node=new Node(source,0);
		queue.add(node);
		
		while(!queue.isEmpty())
		{
			node=queue.poll();
			
			if(node.ver==N)
			{
				System.out.println("Minimum distance to win Snake Ladder for the input given in the code is "+node.min_dist);
				break;
			}
			for(int u:graph.adjList.get(node.ver))
			{
				if(!visited[u])
				{
					visited[u]=true;
					Node n=new Node(u,node.min_dist+1);
					queue.add(n);
				}
			}
		}
	}
	
	static void Solution(Map<Integer,Integer>ladder,Map<Integer,Integer>snake)
	{
		int board=10*10;
		List<Edge>edges=new ArrayList<>();
		
		for(int i=0;i<board;i++)
		{
			for(int j=1;j<=6&&i+j<=board;j++)
			{
				int source=i;
				int dest;
				
				int _ladder=(ladder.get(i+j)!=null)?ladder.get(i+j):0;
				int _snake=(snake.get(i+j)!=null)?snake.get(i+j):0;
				if(_ladder!=0||_snake!=0)
				{
					dest=_ladder+_snake;
				}
				else
					dest=i+j;
				
				edges.add(new Edge(source,dest));
			}
		}
		
		SnakeLadder graph=new SnakeLadder(edges,board);
		bfs(graph,0,board);
	}

	public static void main(String[] args) {
		Map<Integer,Integer>ladder=new HashMap<>();
		ladder.put(1, 38);
        ladder.put(4, 14);
        ladder.put(9, 31);
        ladder.put(21, 42);
        ladder.put(28, 84);
        ladder.put(51, 67);
        ladder.put(72, 91);
        ladder.put(80, 99);
        
        Map<Integer,Integer>snake=new HashMap<>();
        snake.put(17, 7);
        snake.put(54, 34);
        snake.put(62, 19);
        snake.put(64, 60);
        snake.put(87, 36);
        snake.put(93, 73);
        snake.put(95, 75);
        snake.put(98, 79);
        
        Solution(ladder,snake);

	}

}
