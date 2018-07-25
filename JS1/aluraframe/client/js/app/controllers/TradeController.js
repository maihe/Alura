class TradeController {

      constructor() {

            let $ = document.querySelector.bind(document);

            this._inputDate = $('#date');
            this._inputQuantity = $('#quantity');
            this._inputValue = $('#value');
      }

      add(event) {
            event.preventDefault();

            let date = new Date(...this._inputDate
                  .value.split('-')
                  .map(function (item, index) {
                        return item - index % 2;
                  }));

            let trade = new Trade(
                  date,
                  this._inputQuantity.value,
                  this._inputValue.value
            );

            console.log(trade);

      }
}