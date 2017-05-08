import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Math.*;
public class Array{
	 public static void main(String[] args) throws IOException {
	BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
	int arr[][];
	arr=new int [3][3];
	boolean flag=false;
	double cov[][]=new double[3][3];
	double cor[][]=new double[3][3];
	double out[][]=new double[3][3];
	for(int i=0;i<arr.length;i++)
	{
		for(int j=0;j<arr.length;j++)
		{
			arr[i][j]=Integer.parseInt(read.readLine());
		}
	}
	for(int i=0;i<arr.length;i++)
	{
		for(int j=0;j<arr.length;j++)
		{
			if(arr[i][j]!=arr[j][i])
			{
				System.out.print(arr[i][j]+" "+arr[j][i]);
				flag=true;
			}
		}
	}
	if(flag!=true)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				if(i==j)
				{
					double c=Math.sqrt(arr[i][j]);
					double d=1/c;
					cov[i][j]=d;
				}
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				for(int k=0;k<arr.length;k++)
				{
					cor[i][j]=cor[i][j]+arr[i][k]*cov[k][j];
				}
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				for(int k=0;k<arr.length;k++)
				{
					out[i][j]=out[i][j]+cor[i][k]*cov[k][j];
				}
			}
		}
		System.out.println("The Co-relation Matrix:");
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				System.out.print(out[i][j]+" ");
			}
			System.out.println();
		}

	}
	else
	{
		System.out.println("Not covarince Matrix");
	}


	}
}