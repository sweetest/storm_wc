import backtype.storm.Config;
import backtype.storm.StormSubmitter;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;

/**
 * Created by Naver on 14. 3. 24.
 */
public class topology {
	public static void main(String[] args) throws Exception{
		String topologyName = "notifier-storm";

		Config conf = new Config();
		conf.setDebug(false);
		conf.setNumWorkers(10);
		conf.setMaxTaskParallelism(10);
		conf.setMaxSpoutPending(5000);
		conf.put(Config.NIMBUS_HOST,"10.101.19.210");

		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("spout", new RandomSentenceSpout(), 1);
		builder.setBolt("split", new SplitterBolt(), 5).shuffleGrouping("spout");//4
		builder.setBolt("count", new CounterBolt(), 5).fieldsGrouping("split", new Fields("word"));//4


		StormSubmitter.submitJar(conf,"/Users/naver/IdeaProjects/storm-wc/target/storm-wc.jar");

//		StormSubmitter.submitTopology(topologyName, conf, builder.createTopology());
	}
}
