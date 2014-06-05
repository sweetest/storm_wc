import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Naver on 14. 3. 22.
 */
//To be implemented
public class CounterBolt extends BaseBasicBolt {
    private Map<String,Integer> counts = new HashMap<String,Integer>();

	@Override
	public void prepare(Map stormConf, TopologyContext context) {
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
	}

	public void execute(Tuple tuple, BasicOutputCollector collector) {
        //To-do
        //1. tuple에서 단어를 읽어온다.
        String word = "TODO";
        Integer count = counts.get(word);
        if (count == null)
            count = 0;
        count++;
        counts.put(word, count);
        System.out.println(word+":"+count);
    }
}
