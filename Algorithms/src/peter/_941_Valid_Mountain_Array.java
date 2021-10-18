package peter;
/**
给定一个整数数组 arr，如果它是有效的山脉数组就返回?true，否则返回 false。

让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：


	arr.length >= 3
	在?0 < i?< arr.length - 1?条件下，存在?i?使得：
	
		arr[0] < arr[1] < ... arr[i-1] < arr[i] 
		arr[i] > arr[i+1] > ... > arr[arr.length - 1]
	
	


?



?

示例 1：

输入：arr = [2,1]
输出：false


示例 2：

输入：arr = [3,5,5]
输出：false


示例 3：

输入：arr = [0,3,2,1]
输出：true

?

提示：


	1 <= arr.length <= 104
	0 <= arr[i] <= 104

https://leetcode-cn.com/problems/valid-mountain-array

*/public class _941_Valid_Mountain_Array{}