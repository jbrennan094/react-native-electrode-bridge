package com.walmartlabs.electrode.reactnative.bridge;

import android.os.Bundle;

public class ElectrodeBridgeRequest {
    private static final int DEFAULT_REQUEST_TIMEOUT_MS = 5000;

    private final String mName;
    private final Bundle mData;
    private final int mTimeoutMs;

    public enum DispatchMode {
        JS, NATIVE, GLOBAL
    }

    private ElectrodeBridgeRequest(Builder requestBuilder) {
        mName = requestBuilder.mName;
        mData = requestBuilder.mData;
        mTimeoutMs = requestBuilder.mTimeoutMs;
    }

    /**
     * @return The name of this request
     */
    public String getName() {
        return this.mName;
    }

    /**
     * @return The data of this request
     */
    public Bundle getData() {
        return this.mData;
    }

    /**
     * @return The timeout of this request
     */
    public int getTimeoutMs() {
        return this.mTimeoutMs;
    }

    @Override
    public String toString() {
        return mName + ", data: " + (mData != null ? mData : "<empty>");
    }

    public static class Builder {
        private final String mName;
        private Bundle mData;
        private int mTimeoutMs;
        private DispatchMode mDispatchMode;

        /**
         * Initializes a new request builder
         *
         * @param name The name of the request to build
         */
        public Builder(String name) {
            mName = name;
            mTimeoutMs = DEFAULT_REQUEST_TIMEOUT_MS;
            mData = Bundle.EMPTY;
            mDispatchMode = DispatchMode.JS;
        }

        /**
         * Specifies the request timeout
         *
         * @param timeoutMs The timeout in milliseconds
         * @return Current builder instance for chaining
         */
        public Builder withTimeout(int timeoutMs) {
            this.mTimeoutMs = timeoutMs;
            return this;
        }

        /**
         * Specifies the request data
         *
         * @param data The data
         * @return Current builder instance for chaining
         */
        public Builder withData(Bundle data) {
            this.mData = data;
            return this;
        }

        /**
         * Specifies the dispatch mode
         *
         * @param dispatchMode The dispatch mode to use
         * @return Current builder instance for chaining
         */
        public Builder withDispatchMode(DispatchMode dispatchMode) {
            this.mDispatchMode = dispatchMode;
            return this;
        }

        /**
         * Builds the request
         *
         * @return The built request
         */
        public ElectrodeBridgeRequest build() {
            return new ElectrodeBridgeRequest(this);
        }
    }
}
