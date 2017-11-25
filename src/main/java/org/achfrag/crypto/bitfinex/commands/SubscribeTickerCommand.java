package org.achfrag.crypto.bitfinex.commands;

import org.achfrag.crypto.bitfinex.BitfinexApiBroker;
import org.achfrag.crypto.bitfinex.misc.CurrencyPair;
import org.json.JSONObject;

public class SubscribeTickerCommand extends AbstractAPICommand {

	private String currencyPair;

	public SubscribeTickerCommand(final CurrencyPair currencyPair) {
		this.currencyPair = currencyPair.toBitfinexString();
	}
	
	public SubscribeTickerCommand(final String currencyPair) {
		this.currencyPair = currencyPair;
	}

	@Override
	public String getCommand(final BitfinexApiBroker bitfinexApiBroker) {
		final JSONObject subscribeJson = new JSONObject();
		subscribeJson.put("event", "subscribe");
		subscribeJson.put("channel", "ticker");
		subscribeJson.put("symbol", currencyPair);
		
		return subscribeJson.toString();
	}
	
	

}