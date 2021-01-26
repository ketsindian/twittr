package com.twittr.app.commands;

import com.twittr.app.model.AdminActivityRequest;
import com.twittr.app.model.TWEET_COMMAND_TYPE;
import com.twittr.app.repository.AdminActivityRepository;

public abstract class TweetCommandExecutor {

    public abstract boolean isValid(AdminActivityRequest adminActivityRequest);
    //
    public void execute(long activityId,AdminActivityRequest adminActivityRequest) {
        if (!isValid(adminActivityRequest)) {
//            throw new FoodDeliveryException(ExceptionType.MENU_ITEM_NOT_FOUND, "menu item not found");
            System.out.println("Invalid command request !");
        }
        executeCommand(activityId,adminActivityRequest);
    }

    public abstract void executeCommand(long activityId,AdminActivityRequest adminActivity);
//
    public abstract boolean isApplicable(final TWEET_COMMAND_TYPE tweet_command_type);
}

//public abstract class CartCommandExecutor {
//    public void execute(@NonNull final String userId, @NonNull final String restaurantId,
//                        @NonNull final String itemId) {
//        if (!isValid(userId, restaurantId, itemId)) {
//            throw new FoodDeliveryException(ExceptionType.MENU_ITEM_NOT_FOUND, "menu item not found");
//        }
//        executeCommand(userId, restaurantId, itemId);
//    }
//
//    public abstract boolean isValid(final String userId, final String restaurantId, final String itemId);
//
//    public abstract void executeCommand(final String userId, final String restaurantId, final String itemId);
//
//    public abstract boolean isApplicable(final CartCommandType cartCommandType);
//
//}