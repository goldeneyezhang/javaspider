package yibo.zhang.spider.spider1.Compare;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.htmlparser.PrototypicalNodeFactory;
import org.htmlparser.lexer.Lexer;
import org.htmlparser.util.ParserException;
import org.jsoup.nodes.Node;

/**
 * 用lcs最长公共子序列来衡量网页相似度（动态规划）
 * 
 * @author golde
 *
 */
public class HtmlCompare<E> {
	// 计算两个子序列的最长公共子序列的实现如下
	public  <E> List<E> longestCommonSubsequence(E[] s1, E[] s2) {
		// 二维数组，初始化为0
		int[][] num = new int[s1.length + 1][s2.length + 1];
		for (int i = 1; i <= s1.length; i++) {
			for (int j = 1; j <= s2.length; j++) {
				if (s1[i - 1].equals(s2[j - 1]))
					num[i][j] = 1 + num[i - 1][j - 1];
				else
					num[i][j] = Math.max(num[i - 1][j], num[i][j - 1]);
			}
		}
		System.out.println("length of LCS=" + num[s1.length][s2.length]);
		int s1position = s1.length, s2position = s2.length;
		List<E> result = new LinkedList<E>();
		while (s1position != 0 && s2position != 0) {
			if (s1[s1position - 1].equals(s2[s2position - 1])) {
				result.add(s1[s1position - 1]);
				s1position--;
				s2position--;
			} else if (num[s1position][s2position - 1] >= num[s1position - 1][s2position]) {
				s2position--;
			} else {
				s1position--;
			}
		}
		Collections.reverse(result);
		return result;
	}
	
}
