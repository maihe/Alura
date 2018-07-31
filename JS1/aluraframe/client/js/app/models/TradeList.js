class TradeList {

    constructor() {
        this._list = [];
    }

    add(trade) {
        console.log(trade);
        console.log(DateHelper.dateToText(trade.date));
        this._list.push(trade);
    }

    get list() {
        return [].concat(this._negociacoes);
    }
}