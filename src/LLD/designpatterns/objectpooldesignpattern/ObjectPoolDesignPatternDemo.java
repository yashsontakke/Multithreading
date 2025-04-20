package LLD.designpatterns.objectpooldesignpattern;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Resource{
    void use(String name ){
        System.out.println("using resources by thread" + name);
    }
}

class ResourcePool{
    BlockingQueue<Resource> queue =  new LinkedBlockingQueue<>();
    public ResourcePool(int size) {
        for(int i=0;i<size;i++){
            queue.offer(new Resource());
        }
    }
    public Resource acquire() throws InterruptedException {
        return queue.take();   // if empty wait
    }

    public void  release(Resource resource){
         queue.offer(resource);
    }

}

public class ObjectPoolDesignPatternDemo {
    public static void main(String[] args) {
        ResourcePool resourcePool = new ResourcePool(4);
        Runnable task = ()->{
            Resource r = null;
            try {
                r = resourcePool.acquire();

                r.use(Thread.currentThread().getName());

                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resourcePool.release(r);

        };

        for(int i=0;i<10;i++){
            new Thread(task, "Thread"+i).start();
        }

    }
}
