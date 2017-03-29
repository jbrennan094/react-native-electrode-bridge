//
//  ElectrodeBridgeRequestNew.h
//  ElectrodeReactNativeBridge
//
//  Created by Claire Weijie Li on 3/21/17.
//  Copyright © 2017 Walmart. All rights reserved.
//

#import "ElectrodeBridgeMessage.h"
#import <Foundation/Foundation.h>
NS_ASSUME_NONNULL_BEGIN
extern const int kElectrodeBridgeRequestDefaultTimeOut;



@interface ElectrodeBridgeRequestNew : ElectrodeBridgeMessage
/**
 * return timeout of the request in ms.
 */
@property(nonatomic, assign, readonly) int timeoutMs;

/**
 * return if a request was initiated by JS.
 */
@property(nonatomic, assign, readonly) BOOL isJsInitiated;

+(nullable instancetype)createRequestWithData: (NSDictionary *)data;
@end
NS_ASSUME_NONNULL_END