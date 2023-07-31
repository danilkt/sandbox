package io.sandbox.command;

//import io.sandbox.model.UserRepository;
//import io.sandbox.service.TelegramBotService;
//import io.sandbox.user_state.UserState;
//import io.sandbox.utils.KeyboardUtils;
//import io.sandbox.utils.MessageUtils;
//import io.sandbox.utils.TinkoffGrpcUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.telegram.telegrambots.meta.api.objects.Update;
//import ru.tinkoff.piapi.contract.v1.InstrumentIdType;
//import ru.tinkoff.piapi.contract.v1.InstrumentRequest;
//import ru.tinkoff.piapi.contract.v1.ShareResponse;
//
//import java.util.HashMap;
//
//@Component
//public class CompanyData {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public void requestStateHandler(HashMap<Long, UserState> hashMap, Update update, TelegramBotService telegramBotService){
//        hashMap.remove(update.getMessage().getChatId());
//        telegramBotService.sendMessage(MessageUtils.sendMessage(update, "Введите тикер компании ", KeyboardUtils.keyboardCompanyData()));
//        hashMap.put(update.getMessage().getChatId(), UserState.STATE_COMPANY_DATA_RESPONSE);
//    }
////    public void requestKeyboard(HashMap<Long, UserState> hashMap, Update update, TelegramBotService telegramBotService){
////        hashMap.remove(update.getMessage().getChatId());
////        telegramBotService.sendMessage(MessageUtils.sendMessageWithKeyboard(update, "Выберите тип информации", KeyboardUtils.keyboardCompanyData()));
////        hashMap.put(update.getMessage().getChatId(), UserState.STATE_COMPANY_DATA_RESPONSE);
////    }
//
//    public void responseStateHandler(HashMap<Long, UserState> hashMap, Update update, TelegramBotService telegramBotService){
//        var response = response(update, telegramBotService);
//
//        if(response.matches("^https.+")){
//            hashMap.remove(update.getMessage().getChatId());
//        }
//        telegramBotService.sendMessage(MessageUtils.sendMessage(update, response));
//    }
//
//    private String response(Update update, TelegramBotService telegramBotService){
//
//        var token = TinkoffGrpcUtils.getSandboxToken(update, userRepository);
//        var InstrumentStub = TinkoffGrpcUtils.returnInstrumentStub(token);
//        String inputMessage = update.getMessage().getText().toUpperCase();
//
//        try {
//            InstrumentRequest request3 = InstrumentRequest
//                    .newBuilder()
//                    .setIdType(InstrumentIdType.INSTRUMENT_ID_TYPE_TICKER)
//                    .setId(inputMessage)
//                    .setClassCode("TQBR")
//                    .build();
//
//            ShareResponse response3 = InstrumentStub.shareBy(request3);
//        }catch(RuntimeException e ){
//            return "Компании c тикером "+inputMessage+" не существует, попробуйте снова \nНапример : gazp";
//        }
//        if(inputMessage.equals("SNGSP") || inputMessage.equals("SBERP") ||inputMessage.equals("TATNP") ){
//            var InputMessageForPreferredShares = inputMessage.substring(0,inputMessage.length()-1);
//            return "https://smart-lab.ru/q/"+InputMessageForPreferredShares+"/f/y/";
//        }
//
//        return "https://smart-lab.ru/q/"+inputMessage.toUpperCase()+"/f/y/";
//    }
//}