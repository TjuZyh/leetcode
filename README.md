### Leetcode Node

------

**java语言**

#### 1. 大小顶推

**PriorityQueue + Comparator**

对于某些排序类问题，可以通过创建大小顶堆（可以在PriorityQueue中自定义排序方式）后，向其中添加数据的方式实现数据的排序

```java
		//创建小顶堆
    @Test
    public void test1(){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        priorityQueue.offer(2);
        priorityQueue.offer(1);
        priorityQueue.offer(4);
        priorityQueue.offer(3);

        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }

		//利用lambda表达式创建大顶堆
    @Test
    public void test2(){
        PriorityQueue<String> priorityQueue = new PriorityQueue<>((s1 , s2) -> {
            return -s1.compareTo(s2);
        });
    }
```

#### 2. 关于链表

##### 1.链表中间位置

**利用快慢指针，快指针每次走两步，慢指针走一步，当快指针遍历到链表尾时，慢指针恰好到达链表中间**

```java
public ListNode middleNode1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
```

##### 2.链表反转

**a. 利用栈的性质，先入后出，当做容器进行链表反转**

```java
private ListNode reverse1(ListNode head){
    Stack<ListNode> stack = new Stack<>();
    ListNode newHead = head;
    while(newHead != null){
        stack.push(newHead);
        newHead = newHead.next;
    }

    head = stack.pop();
    //这里不能直接操作head，因为要返回链表头head
    ListNode cur = head;
    while(!stack.isEmpty()){
        //创建新节点
        ListNode node = stack.pop();
        //去引用，存入栈时还保留之前的链接关系
        node.next = null;
        //与链表链接
        cur.next = node;
        //移动指针，准备链接下一个新节点
        cur = node;
    }
    return head;
}
```

**b. 迭代：在遍历链表时，将当前节点的 next 指针改为指向前一个节点。由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。在更改引用之前，还需要存储后一个节点。最后返回新的头引用**

```java
		public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
```

**c. 递归 **

```java
		public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
```

#### 3. 搜索

##### 1. BFS：广度优先遍历

**BFS通常利用队列的先入先出的特性来实现**

<img src="/Users/zyh/Library/Application Support/typora-user-images/image-20220314122451400.png" alt="image-20220314122451400" style="zoom:50%;" />

遍历次序为：[3, 9, 2, 1, 7]

**算法实现流程：以广度遍历二叉树为例**

- 特判：当树的根为空时，直接返回空列表[]
- 初始化：创建Queue以及List，将树的root入队
- BFS循环：当队列为空时跳出
  - 出队：队列的首元素（节点）出队
  - 记录：将首元素（节点）的值存入List
  - 添加子节点：若当前元素（节点）的左/右子节点不为空，则将左/右子节点入队
- 返回：返回维护好的list即可

```java
//BFS:广度优先搜索
//BFS的实现经常借助队列的先入先出实现
//维护一个队列，在遍历二叉树的时候一次将节点按次序入队，后依次写入数组即可
public int[] levelOrder(TreeNode root) {
    //特判
    if(root == null){
        return new int[0];
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>(){{ add(root); }};
    ArrayList<Integer> arrayList = new ArrayList<>();
    //BFS
    while(!queue.isEmpty()){
        TreeNode curNode = queue.poll();
        arrayList.add(curNode.val);
        if(curNode.left != null){
            queue.add(curNode.left);
        }
        if(curNode.right != null){
            queue.add(curNode.right);
        }
    }
    int[] res = new int[arrayList.size()];
    /*for(int i = 0 ; i < arrayList.size() ; i++){
        res[i] = arrayList.get(i);
    }*/
    //stream流实现List转数组
    res = arrayList.stream().mapToInt(Integer::valueOf).toArray();
    return res;
}
```

##### 2. DFS：深度优先遍历

DFS解决二叉树路径问题：

- 自顶向下：从某一个节点(不一定是根节点)，从上向下寻找路径，到某一个节点(不一定是叶节点)结束；
- 非自定向下：从任意节点到任意节点的路径，不需要自顶向下

模板：自顶向下

```java
private List<List<Integer>> res;
public void dfs(TreeNode root , List<Integer> path){
    if(root == null) return;
    //选择当前元素是否加入到路径中
    path.add(root.val);
    //叶子节点，即到达路径尽头，在res添加路径，并返回
    if(root.left == null && root.right == null){
        res.add(path);
        return;
    }
    //递归左右子树
    dfs(root.left , path);
    dfs(root.right, path);
}
```

模板：非自顶向下

基本思路：设计一个辅助函数dfs2，调用自身求出以一个节点为根节点的左侧最长路径left和右侧最长路径right，那么经过该节点的最长路径就是left+right
接着只需要从根节点开始dfs,不断比较更新全局变量即可

```java
private int ans = 0;
public int dfs2(TreeNode root){
    if(root == null) return 0;
    int left = dfs2(root.left);
    int right = dfs2(root.right);
    ans = Math.max(ans , left + right + root.val);
    return Math.max(left , right);
}
```

#### 4. 二分搜索

**二分模板**

- **寻找第一个满足条件的位置：**

  ```java
  int low = 0 , high = nums.length - 1;
  if(low < high){
    	//注意这里无需加一，向下取整
      int mid = (high - low) / 2 + low;
      if(满足条件){
          high = mid;
      }else{
          low = mid + 1;
      }
  }
  ```

- **寻找最后一个满足条件的位置：**

  ```java
  int low = 0 , high = nums.length - 1;
  if(low < high){
    	//注意这里需要向上取整
      int mid = (high - low + 1) / 2 + low;
      if(满足条件){
          low = mid;
      }else{
          high = mid - 1;
      }
  }
  ```


#### 5. 位运算

##### 1. 基础运算符

```java
| 或运算 有1为1
6 | 5 = 110 | 101 = 111 = 7

$ 与运算 同1为1
6 & 5 = 110 & 101 = 100 = 4
  
<< 左移运算 
3 << 1 = 011 << 1 = 0110 = 6
  
>> 右移运算
3 >> 1 = 011 >> 1 = 001 = 1
  
^ 异或运算 不同为1
4 ^ 6 = 100 ^ 110 = 010 = 2
```

##### 2. 一些小技巧

- 翻转二进制数字

  ```java
  int num = 12; // 1100
  int reverse = ((1 << 4) - 1) ^ num; //0011
  ```

- 将01数组中的元素合并到一个二进制数字中

  ```java
  int[] arr = {1,0,1,0,1};
  int merge = 0;
  for(int i = 0 ; i < arr.length ; i++){
  	merge |= (arr[i] << i);
  }
  ```

- 获取二进制数字中1的个数，Integer.bitCount()函数

  ```java
  int ones = Integer.bitCount(num)
  ```

- 去除掉二进制数字奇数位或偶数位上的1

  将二进制数字与 (1010 1010 1010 1010 1010 1010 1010 1010) = 0xAAAAAAAA相与，可以去除掉奇数位上的1

  将二进制数字与 (0101 0101 0101 0101 0101 0101 0101 0101) = 0x55555555相与，可以去除掉偶数位上的1

  ```java
  num & 0xAAAAAAAA
  num & 0x55555555
  ```

#### 6. 单调栈

应用场景：

- 求一个数组元素的下一个最大或最小值、判断当前元素符合某种条件的左右边界

- **凡是看到需要用到第一个小于(等于)/大于(等于)该元素的元素，多半可以使用单调栈**

例题：[商品折扣后的最终价格](https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/)

大致意思为给一个数组，找出当前数组位置右侧第一个小于该位置上数值的元素

```java
/*
* 单调栈：凡是看到需要用到第一个小于(等于)/大于(等于)该元素的元素，多半可以使用单调栈
*   维护一个单调栈，查询元素对应位置右侧的最小元素无需遍历右侧数组，只需访问栈顶元素即可
*   倒序遍历数组，每当移动到新的位置，将栈中大于数组当前位置值的元素pop，这样栈顶就是数组右侧第一个最小元素，直接相减即可
* */
public int[] finalPrices1(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[prices.length];
        for(int i = prices.length - 1 ; i >= 0 ; i--){
            //将栈顶元素调整为右侧第一个小于price[i]的元素
            while(!stack.isEmpty() && stack.peek() > prices[i]){
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return ans;
    }
```







