/**
 * 
 */
package com.dell.isg.smi.adapter.server.powerthermal;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dell.isg.smi.adapter.server.model.WsmanCredentials;
import com.dell.isg.smi.wsman.command.WSManClassEnum;
import com.dell.isg.smi.wsmanclient.IWSManClient;
import com.dell.isg.smi.wsmanclient.WSManClientFactory;
import com.dell.isg.smi.wsmanclient.impl.DefaultEnumerate;

/**
 * @author Muqeeth_Kowkab
 *
 */
public class PowerThermalAdapterImpl2_0 implements IPowerThermalAdapter2_0 {
	
	private static final Logger logger = LoggerFactory.getLogger(PowerThermalAdapterImpl2_0.class);

	@Override
	public Object collectPowerMonitoring(WsmanCredentials credentials) throws Exception {
		
		Map<String, Object> results = new LinkedHashMap<>();
		IWSManClient wsmanClient = null;
		try {
			wsmanClient = WSManClientFactory.getClient(credentials.getAddress(), credentials.getUserName(), credentials.getPassword());
			
			results.put(WSManClassEnum.DCIM_SystemView.name(), wsmanClient.execute(new DefaultEnumerate<Object>(WSManClassEnum.DCIM_SystemView)));
			results.put(WSManClassEnum.DCIM_BaseMetricValue.name(), wsmanClient.execute(new DefaultEnumerate<Object>(WSManClassEnum.DCIM_BaseMetricValue)));
			results.put(WSManClassEnum.DCIM_AggregationMetricValue.name(), wsmanClient.execute(new DefaultEnumerate<Object>(WSManClassEnum.DCIM_AggregationMetricValue)));
			results.put(WSManClassEnum.DCIM_BIOSEnumeration.name(), wsmanClient.execute(new DefaultEnumerate<Object>(WSManClassEnum.DCIM_BIOSEnumeration)));
			results.put(WSManClassEnum.DCIM_PSNumericsensor.name(), wsmanClient.execute(new DefaultEnumerate<Object>(WSManClassEnum.DCIM_PSNumericsensor)));
			
		} finally {
			wsmanClient.close();
		}	
		return results;
	}

}
