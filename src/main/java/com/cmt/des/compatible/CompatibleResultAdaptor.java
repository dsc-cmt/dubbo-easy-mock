package com.cmt.des.compatible;

import com.alibaba.dubbo.rpc.Result;

import java.util.Map;
import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 兼容 alibaba dubbo 和 apache dubbo的 Result
 * @author shengchaojie
 * @date 2020-03-10
 **/
public abstract class CompatibleResultAdaptor implements Result {
    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public Throwable getException() {
        return null;
    }

    @Override
    public boolean hasException() {
        return false;
    }

    @Override
    public Object recreate() throws Throwable {
        return null;
    }

    @Override
    public Map<String, String> getAttachments() {
        return null;
    }

    @Override
    public void addAttachments(Map<String, String> map) {

    }

    @Override
    public void setAttachments(Map<String, String> map) {

    }

    @Override
    public String getAttachment(String key) {
        return null;
    }

    @Override
    public String getAttachment(String key, String defaultValue) {
        return null;
    }

    @Override
    public void setAttachment(String key, String value) {

    }

    @Override
    public org.apache.dubbo.rpc.Result getNow(org.apache.dubbo.rpc.Result valueIfAbsent) {
        return null;
    }

    @Override
    public org.apache.dubbo.rpc.Result whenCompleteWithContext(BiConsumer<org.apache.dubbo.rpc.Result, Throwable> fn) {
        return null;
    }

    @Override
    public <U> CompletionStage<U> thenApply(Function<? super org.apache.dubbo.rpc.Result, ? extends U> fn) {
        return null;
    }

    @Override
    public <U> CompletionStage<U> thenApplyAsync(Function<? super org.apache.dubbo.rpc.Result, ? extends U> fn) {
        return null;
    }

    @Override
    public <U> CompletionStage<U> thenApplyAsync(Function<? super org.apache.dubbo.rpc.Result, ? extends U> fn, Executor executor) {
        return null;
    }

    @Override
    public CompletionStage<Void> thenAccept(Consumer<? super org.apache.dubbo.rpc.Result> action) {
        return null;
    }

    @Override
    public CompletionStage<Void> thenAcceptAsync(Consumer<? super org.apache.dubbo.rpc.Result> action) {
        return null;
    }

    @Override
    public CompletionStage<Void> thenAcceptAsync(Consumer<? super org.apache.dubbo.rpc.Result> action, Executor executor) {
        return null;
    }

    @Override
    public CompletionStage<Void> thenRun(Runnable action) {
        return null;
    }

    @Override
    public CompletionStage<Void> thenRunAsync(Runnable action) {
        return null;
    }

    @Override
    public CompletionStage<Void> thenRunAsync(Runnable action, Executor executor) {
        return null;
    }

    @Override
    public <U, V> CompletionStage<V> thenCombine(CompletionStage<? extends U> other, BiFunction<? super org.apache.dubbo.rpc.Result, ? super U, ? extends V> fn) {
        return null;
    }

    @Override
    public <U, V> CompletionStage<V> thenCombineAsync(CompletionStage<? extends U> other, BiFunction<? super org.apache.dubbo.rpc.Result, ? super U, ? extends V> fn) {
        return null;
    }

    @Override
    public <U, V> CompletionStage<V> thenCombineAsync(CompletionStage<? extends U> other, BiFunction<? super org.apache.dubbo.rpc.Result, ? super U, ? extends V> fn, Executor executor) {
        return null;
    }

    @Override
    public <U> CompletionStage<Void> thenAcceptBoth(CompletionStage<? extends U> other, BiConsumer<? super org.apache.dubbo.rpc.Result, ? super U> action) {
        return null;
    }

    @Override
    public <U> CompletionStage<Void> thenAcceptBothAsync(CompletionStage<? extends U> other, BiConsumer<? super org.apache.dubbo.rpc.Result, ? super U> action) {
        return null;
    }

    @Override
    public <U> CompletionStage<Void> thenAcceptBothAsync(CompletionStage<? extends U> other, BiConsumer<? super org.apache.dubbo.rpc.Result, ? super U> action, Executor executor) {
        return null;
    }

    @Override
    public CompletionStage<Void> runAfterBoth(CompletionStage<?> other, Runnable action) {
        return null;
    }

    @Override
    public CompletionStage<Void> runAfterBothAsync(CompletionStage<?> other, Runnable action) {
        return null;
    }

    @Override
    public CompletionStage<Void> runAfterBothAsync(CompletionStage<?> other, Runnable action, Executor executor) {
        return null;
    }

    @Override
    public <U> CompletionStage<U> applyToEither(CompletionStage<? extends org.apache.dubbo.rpc.Result> other, Function<? super org.apache.dubbo.rpc.Result, U> fn) {
        return null;
    }

    @Override
    public <U> CompletionStage<U> applyToEitherAsync(CompletionStage<? extends org.apache.dubbo.rpc.Result> other, Function<? super org.apache.dubbo.rpc.Result, U> fn) {
        return null;
    }

    @Override
    public <U> CompletionStage<U> applyToEitherAsync(CompletionStage<? extends org.apache.dubbo.rpc.Result> other, Function<? super org.apache.dubbo.rpc.Result, U> fn, Executor executor) {
        return null;
    }

    @Override
    public CompletionStage<Void> acceptEither(CompletionStage<? extends org.apache.dubbo.rpc.Result> other, Consumer<? super org.apache.dubbo.rpc.Result> action) {
        return null;
    }

    @Override
    public CompletionStage<Void> acceptEitherAsync(CompletionStage<? extends org.apache.dubbo.rpc.Result> other, Consumer<? super org.apache.dubbo.rpc.Result> action) {
        return null;
    }

    @Override
    public CompletionStage<Void> acceptEitherAsync(CompletionStage<? extends org.apache.dubbo.rpc.Result> other, Consumer<? super org.apache.dubbo.rpc.Result> action, Executor executor) {
        return null;
    }

    @Override
    public CompletionStage<Void> runAfterEither(CompletionStage<?> other, Runnable action) {
        return null;
    }

    @Override
    public CompletionStage<Void> runAfterEitherAsync(CompletionStage<?> other, Runnable action) {
        return null;
    }

    @Override
    public CompletionStage<Void> runAfterEitherAsync(CompletionStage<?> other, Runnable action, Executor executor) {
        return null;
    }

    @Override
    public <U> CompletionStage<U> thenCompose(Function<? super org.apache.dubbo.rpc.Result, ? extends CompletionStage<U>> fn) {
        return null;
    }

    @Override
    public <U> CompletionStage<U> thenComposeAsync(Function<? super org.apache.dubbo.rpc.Result, ? extends CompletionStage<U>> fn) {
        return null;
    }

    @Override
    public <U> CompletionStage<U> thenComposeAsync(Function<? super org.apache.dubbo.rpc.Result, ? extends CompletionStage<U>> fn, Executor executor) {
        return null;
    }

    @Override
    public CompletionStage<org.apache.dubbo.rpc.Result> exceptionally(Function<Throwable, ? extends org.apache.dubbo.rpc.Result> fn) {
        return null;
    }

    @Override
    public CompletionStage<org.apache.dubbo.rpc.Result> whenComplete(BiConsumer<? super org.apache.dubbo.rpc.Result, ? super Throwable> action) {
        return null;
    }

    @Override
    public CompletionStage<org.apache.dubbo.rpc.Result> whenCompleteAsync(BiConsumer<? super org.apache.dubbo.rpc.Result, ? super Throwable> action) {
        return null;
    }

    @Override
    public CompletionStage<org.apache.dubbo.rpc.Result> whenCompleteAsync(BiConsumer<? super org.apache.dubbo.rpc.Result, ? super Throwable> action, Executor executor) {
        return null;
    }

    @Override
    public <U> CompletionStage<U> handle(BiFunction<? super org.apache.dubbo.rpc.Result, Throwable, ? extends U> fn) {
        return null;
    }

    @Override
    public <U> CompletionStage<U> handleAsync(BiFunction<? super org.apache.dubbo.rpc.Result, Throwable, ? extends U> fn) {
        return null;
    }

    @Override
    public <U> CompletionStage<U> handleAsync(BiFunction<? super org.apache.dubbo.rpc.Result, Throwable, ? extends U> fn, Executor executor) {
        return null;
    }

    @Override
    public CompletableFuture<org.apache.dubbo.rpc.Result> toCompletableFuture() {
        return null;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public org.apache.dubbo.rpc.Result get() throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public org.apache.dubbo.rpc.Result get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
