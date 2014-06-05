import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * Created by Naver on 14. 3. 22.
 */
//To be implemented
public class CounterBolt extends BaseBasicBolt {
	public static Logger logger = LoggerFactory.getLogger("notifier");
	private static Jedis jedis;

	@Override
	public void prepare(Map stormConf, TopologyContext context) {
		jedis = new Jedis("10.99.212.104",6379);
		jedis.select(1);
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
	}

	public void execute(Tuple tuple, BasicOutputCollector collector) {
		String word = tuple.getString(0);
		jedis.incr(word);
	}
}
