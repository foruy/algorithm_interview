package com.datastructure.exercise;

/**
 * 约瑟夫环
 * 问题描述：n个人（编号0~(n-1))，从0开始报数，报到(m-1)的退出，
 * 剩下的人继续从0开始报数。求胜利者的编号。 
 */
public class JosephusProblem {
	
	public static void main(String[] args) {
		JosephusProblem test = new JosephusProblem();
		System.out.println(test.winnerIndex(10, 1));
	}
	
	/**
	 * @param n 总人数
	 * @param m 退出位置
	 * 初始化人员位置如下0,1,2,3,4,5,6,...(n-1)
	 * 1、第一个被删除的元素为(m-1)%n
	 * 2、第一次报数后剩余的人员:0,1,2,...(m-1),m,(m+1),...(n-1)
	 * 3、第二次报数从k开始，队列如下：k,(k+1),...(n-1),0,1,2,...(k-2)
	 * 4、对上面的队列进行重新编号，0,1,...(n-k-1),(n-k),(n-k+1),...(n-1)
	 * 5、根据第四步得出如下映射关系：
	 * 	k---0
	 * 	k+1---1
	 * 	k+2---2
	 * 	...
	 *  k-3---n-2
	 * 	k-2---n-1
	 * 6、第一次报数后剩余n-1人，假设n-1人中报数最后的编号是x,根据映射关系，x对应着k+x,
	 * n-1报数最后留下的编号就是n个人员报数留下的编号，则n个人员报数留下的编号为(k+x)%n,
	 * 其中k=m%n,代入((x+k)%n<=>(x+(m%n))%n<=>(x%n+(m%n)%n)%n
	 * <=>(x%n+m%n)%n<=>(x+m)%n
	 * 7、第二个被删除的数为(m-1)%(n-1)
	 * 8、假设第三轮的开始数字为o，那么这n-2个数构成的约瑟夫环为o,o+1,o+2,...o-3,o-2。继续做映射。
	 * 	o---0
	 * 	o+1---1
	 * 	o+2---2
	 * 	...
	 *  o-3---n-3
	 *  o-2---n-2
	 *  这是一个n-2个人的问题。假设最后的胜利者为y，那么n-1个人时，胜利者为 (y+o)%(n-1)，
	 *  其中o等于m%(n-1)。代入可得 (y+m)%(n-1). 
	 *  要得到n-1个人问题的解，只需得到n-2个人问题的解，倒推下去。
	 *  只有一个人时，胜利者就是编号0。下面给出递推式：
          f [1] = 0; 
          f [i] = (f[i-1]+m)%i; (i>2) 
	 */
	public int winnerIndex(int n,int m){
		int[] f = new int[n+1];
		f[0] = f[1] = 0;
		for(int i = 2;i<=n;i++){
			f[i] = (f[i-1]+m)%i;
		}
		return f[n];
	}

}
