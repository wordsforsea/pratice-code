package top.xzit;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
//import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.InputStream;

//����Ϊ�˸�ϰ�ķ��㣬����Ҫ����Ƶ�ļ������е��ܽ������ŵ�һ���ļ����У�
//�ֶ�����û����˼����֮ǰѧϰ��֪ʶ���ع���ʵ�ò���
//�����õ���֪ʶ��  �ļ��ı��� �ļ���д   ���ַ����Ĳ���  �� �ݹ飿
//����  
//1.�Ȼ�ȡָ��Ŀ¼�����е��ļ���
//2.�ж��Ƿ���.avi��β
//3.�Ի�ȡ���ַ������в�����ƥ�京���ܽ����Ƶ�ļ�
// ·�� ��F:\java


//ok i complete the code
public class copyFileFirstVersion {
	public static void main(String[] args) throws IOException{
		File f = new File("F:\\java");
		File F1 = new File("f:\\demo");
		F1.mkdir();
		fileName(f);
		//copyFile(); ��һ���Զ�����
	}

	private static void copyFile(File file) throws IOException{
		// TODO Auto-generated method stub
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(
				new File("f:\\demo\\"+file.getName())));
		//��д���Ѿ�д���ˣ���ô��д�ر���
		int length = 0;
		byte[] b = new byte[2048];
		
		while((length = bis.read(b))!=-1) {
			bos.write(b, 0, length);//�����ļ�
		}
		
		bis.close();
		bos.close();//��Ҳ�ر���
	}

	private static void fileName(File f) throws IOException{
		// TODO Auto-generated method stub
		File[] fileArray = f.listFiles();//��file���������� Ȼ���ж��Ƿ����ļ���
		for(File file:fileArray) {
			if(!(file.isDirectory())) {
				//˵���ⲿ�����ļ������Ժ�������
				//if(file.getName().endsWith(".ppt")) 
				if(file.getName().endsWith("�ܽ�.avi")){
					System.out.println(file.getAbsolutePath());//ok �ܰ����е��ļ�����������
					//���Ѿ���õ��ļ����и���
					copyFile(file);
				}
				//copyFile(file);
			}else {
				fileName(file);
			}
		}
	}

	
}