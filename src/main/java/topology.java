import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;

/**
 * Created by Naver on 14. 3. 24.
 */
public class topology {
	public static void main(String[] args) throws Exception{
		Config conf = new Config();
		conf.setDebug(false);
		conf.setNumWorkers(10);
		conf.setMaxTaskParallelism(10);
		conf.setMaxSpoutPending(5000);

		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("spout", new RandomSentenceSpout(), 1);
        //To-do
        //1. RandomSentenceSpout을 shufflegrouping 방식으로 SplitterBolt에 연결시킨다.
        //2. SplitterBolt를 적절한 방식으로 CounterBolt에 연결시킨다,


        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("word-count", conf, builder.createTopology());
	}
}
