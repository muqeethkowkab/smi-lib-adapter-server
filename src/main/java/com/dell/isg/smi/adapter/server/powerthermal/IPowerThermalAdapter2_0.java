package com.dell.isg.smi.adapter.server.powerthermal;

import com.dell.isg.smi.adapter.server.model.WsmanCredentials;

public interface IPowerThermalAdapter2_0 {
	
	public Object collectPowerMonitoring(WsmanCredentials credentials) throws Exception;

}
