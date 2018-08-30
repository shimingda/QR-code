package com.dome.concurrence.base;
class RunnableDemo implements Runnable {
    Message message;
    public  RunnableDemo(Message message){
        this.message=message;
    }

    @Override
    public void run() {
        for (int i=1;i<100;i++){
            synchronized (this){

             System.out.println(message.getMsg()+"----"+i);
            }
        }
    }
}
class Message{
    private int no;
    private String msg;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
 class TestThread {

    public static void main(String args[]) {
        Message message=new Message();
        message.setMsg("one");
        Thread t=new Thread(new RunnableDemo(message));
        Message message2=new Message();
        message2.setMsg("two");
        Thread t2=new Thread(new RunnableDemo(message2));
        t.start();
        t2.start();
    }
}