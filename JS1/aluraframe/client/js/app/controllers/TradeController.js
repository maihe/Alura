class TradeController {

      constructor() {

            let $ = document.querySelector.bind(document);

            this._inputDate = $('#date');
            this._inputQuantity = $('#quantity');
            this._inputValue = $('#value');
            this._tradeList = new TradeList();
      }

      add(event) {
            event.preventDefault();
            this._tradeList.add(this._instantiateTrade());
            this._cleanForm();
            console.log(this._tradeList._list);
      }


      _instantiateTrade() {
            return new Trade(
                  DateHelper.textToDate(this._inputDate.value),
                  this._inputQuantity.value,
                  this._inputValue.value
            );
      }

      _cleanForm() {
            this._inputDate.value = "";
            this._inputQuantity.value = "";
            this._inputValue.value = "";
            this._inputDate.focus();

      }
}