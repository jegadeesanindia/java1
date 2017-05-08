import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Filearray{
    public static void main(String[] args) throws FileNotFoundException,IOException {
    	BufferedReader read=new BufferedReader(new FileReader("Visitor.txt"));
    	BufferedReader scan=new BufferedReader(new InputStreamReader(System.in));
    	int visit[][][];
		int days[]={31,29,31,30,31,30,31,31,30,31,30,31};
    	visit=new int[12][][];
		for(int i=0;i<days.length;i++ )
		{
			visit[i]=new int[days[i]][24];
		}
    	
    	for (int i=0;i<visit.length;i++ ) 
    	{
    		for (int j=0;j<visit[i].length;j++ )
    		 {
    			for (int k=0;k<visit[i][j].length ;k++ )
    			 {
						visit[i][j][k]=Integer.parseInt(read.readLine());    				
    			}
    			
    		}
    		
    	}
		do
		{
			System.out.print("1.Average and sum of Vistors in a Particuar Month\n");
			System.out.print("2.Average and sum of Vistors in a Particuar Day \n");
			System.out.print("3.Average and sum of Vistors in a Particuar hour\n");
			System.out.print("4.Average and sum of Vistors in a Particuar Month With Start and end\n");
			System.out.print("5.Average and sum of Vistors in a Particuar day With Bounadry Values\n");
			System.out.print("6.Average and sum of Vistors in a Particuar hour with Boundary values \n");
			System.out.print("7.Average and sum of Vistors in a Particuar  Month Multipe boundary VAlues\n");
			System.out.print("8.Average and sum of Vistors in a Particuar Days Multiple boundary values\n");
			System.out.print("9.Average and sum of Vistors in a Particuar Hours have Multiple values\n");
			System.out.print("10.Average and sum of Vistors in a Particuar All have multiple boudary values\n");
			int ch=Integer.parseInt(scan.readLine());
			int sum=0;
			double avg=0;
			switch(ch)
			{
				case 1:System.out.print("Enter Month:");
				int mon=Integer.parseInt(scan.readLine());
				for(int i=0;i<visit[mon].length;i++)
				{
					for(int j=0;j<visit[mon][i].length;j++)
					{
						sum=sum+visit[mon][i][j];
					}
				}
				avg=sum/(visit[mon].length*24);
				System.out.println("Sum:"+sum);
				System.out.println("Average:"+avg);
				break;
				case 2:System.out.print("Enter Days:");
				int day=Integer.parseInt(scan.readLine());
				day=day-1;
				for(int i=0;i<visit.length;i++)
				{
					if(visit[i].length<=day)
					{
						continue;
					}
					else
					{
					for(int j=0;j<visit[i][day].length;j++)
					{
						sum=sum+visit[i][day][j];
					}
					}
				}
				avg=sum/(visit.length*24);
				System.out.println("Sum:"+sum);
				System.out.println("Average:"+avg);
				break;
				case 3:System.out.print("Enter Hour:");
				int hour=Integer.parseInt(scan.readLine());;
				for(int i=0;i<visit.length;i++)
				{
					for(int j=0;j<visit[i].length;j++)
					{
						sum=sum+visit[i][j][hour];
					}
				}
				avg=sum/(366);
				System.out.println("Sum:"+sum);
				System.out.println("Average:"+avg);
				break;
				case 4:System.out.print("Enter month Start Value:");
				int s_Value=Integer.parseInt(scan.readLine());
				System.out.print("Enter month End Value:");
				int e_Value=Integer.parseInt(scan.readLine());
				for(int i=s_Value;i<e_Value;i++)
				{
					for(int j=0;j<visit[i].length;j++)
					{
						for(int k=0;k<visit[i][j].length;k++){
							sum=sum+visit[i][j][k];
						}
					}
				}
				avg=sum/((e_Value-s_Value)*366);
				System.out.println("Sum:"+sum);
				System.out.println("Average:"+avg);
				break;
			case 5:
				System.out.print("Enter Month Value:");
				int month=Integer.parseInt(scan.readLine());
				System.out.print("Enter day Start Value:");
				int sd_Value=Integer.parseInt(scan.readLine());
				int src=sd_Value;
				System.out.print("Enter day End Value:");
				int ed_Value=Integer.parseInt(scan.readLine());
				for(int i=0;i<visit.length;i++)
				{
					if(visit[i].length<=sd_Value)
					{
						continue;
					}
					else
					{
					for(int j=0;j<visit[i][sd_Value].length;j++)
					{
						sum=sum+visit[i][sd_Value][j];
					}
					}
					sd_Value++;
					if(sd_Value>ed_Value)
					break;
				}
				avg=sum/((ed_Value-src)*24);
				System.out.println("Sum:"+sum);
				System.out.println("Average:"+avg);
				break;
			case 6:
				System.out.print("Enter Month Value:");
				int monthh=Integer.parseInt(scan.readLine());
				System.out.print("Enter day  Value:");
				int Day=Integer.parseInt(scan.readLine());
				System.out.print("Enter Hour Start Value:");
				int sh_Value=Integer.parseInt(scan.readLine());
				int src1=sh_Value;
				System.out.print("Enter Hour End Value:");
				int eh_Value=Integer.parseInt(scan.readLine());
					for(int j=sh_Value;j<visit[monthh][Day].length;j++)
					{
						sum=sum+visit[monthh][Day][j];
						j++;
						if(j>eh_Value)
						break;
					}
				avg=sum/((eh_Value-src1));
				System.out.println("Sum:"+sum);
				System.out.println("Average:"+avg);
				break;
				case 7:System.out.print("Enter No of boundary Values:");
				int T=Integer.parseInt(scan.readLine());
				for(int m=0;m<T;m++)
				{
				System.out.print("Enter month Start Value of"+m+":");
				int smd_Value=Integer.parseInt(scan.readLine());
				System.out.print("Enter month End Value"+m+":");
				int emd_Value=Integer.parseInt(scan.readLine());
				for(int i=smd_Value;i<emd_Value;i++)
				{
					for(int j=0;j<visit[i].length;j++)
					{
						for(int k=0;k<visit[i][j].length;k++){
							sum=sum+visit[i][j][k];
						}
					}
				}
				avg=sum/((emd_Value-smd_Value)*366);
				System.out.println("Sum:"+sum);
				System.out.println("Average:"+avg);
				}
				break;
				case 8:System.out.print("Enter No of boundary Values:");
				int T1=Integer.parseInt(scan.readLine());
				for(int m=0;m<T1;m++)
				{
				System.out.print("Enter Month Value:");
				int monm=Integer.parseInt(scan.readLine());
				System.out.print("Enter day Start Value:");
				int smd_Value=Integer.parseInt(scan.readLine());
				int src2=smd_Value;
				System.out.print("Enter day End Value:");
				int emd_Value=Integer.parseInt(scan.readLine());
				for(int i=0;i<visit.length;i++)
				{
					if(visit[i].length<=smd_Value)
					{
						continue;
					}
					else
					{
					for(int j=0;j<visit[i][smd_Value].length;j++)
					{
						sum=sum+visit[i][smd_Value][j];
					}
					}
					smd_Value++;
					if(smd_Value>emd_Value)
					break;
				}
				avg=sum/((emd_Value-src2)*24);
				System.out.println("Sum:"+sum);
				System.out.println("Average:"+avg);

				}
							break;
			case 9:System.out.print("Enter No of boundary Values:");
				int T3=Integer.parseInt(scan.readLine());
				for(int m=0;m<T3;m++)
				{
				System.out.print("Enter Month Value:");
				int monmh=Integer.parseInt(scan.readLine());
				System.out.print("Enter day  Value:");
				int Days=Integer.parseInt(scan.readLine());
				System.out.print("Enter Hour Start Value:");
				int smh_Value=Integer.parseInt(scan.readLine());
				int src3=smh_Value;
				System.out.print("Enter Hour End Value:");
				int emh_Value=Integer.parseInt(scan.readLine());
					for(int j=smh_Value;j<visit[monmh][Days].length;j++)
					{
						sum=sum+visit[monmh][Days][j];
						j++;
						if(j>emh_Value)
						break;
					}
				avg=sum/((emh_Value-src3));
				System.out.println("Sum:"+sum);
				System.out.println("Average:"+avg);
				}
			}

			
		}
		while(true);


}
}