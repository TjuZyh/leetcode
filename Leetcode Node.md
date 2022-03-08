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

**c.递归 **

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

