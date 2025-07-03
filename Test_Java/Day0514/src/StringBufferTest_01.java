
public class StringBufferTest_01 {
	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer("Korea");
		StringBuffer sb3 = new StringBuffer(50);
		
		System.out.println("용량: " + sb1.capacity());

		sb1.append(12)
		   .append('a')
		   .append("hahaha")
		   .append(true)
   		   .append("asdfasdf asdf asdf asdf");
		
		System.out.println("용량: " + sb1.capacity());
		
		sb2.append("n");
		System.out.println(sb2);
		
		sb2.replace(0, 1, "C");
		System.out.println(sb2);
		
		sb2.insert(5, "Hello~ ");
		System.out.println(sb2);
		
		int position = sb2.indexOf("n");
		sb2.delete(position, position+1);
		System.out.println(sb2);
		
		
		sb2.reverse();
		System.out.println(sb2);
		
		System.out.println(sb2.capacity());
		System.out.println(sb2.length());
		
		sb2.trimToSize();
		System.out.println(sb2.capacity());
		System.out.println(sb2.length());
		
		String str = sb2.toString();
		
	}

}
