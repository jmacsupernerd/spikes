package com.novoda.pianohero;

import android.util.Log;

class AndroidGameMvpView implements GameMvp.View {

    private final GameScreen gameScreen;
    private final Speaker speaker;
    private final ScoreDisplayer scoreDisplayer;

    AndroidGameMvpView(GameScreen gameScreen, Speaker speaker, ScoreDisplayer scoreDisplayer) {
        this.gameScreen = gameScreen;
        this.speaker = speaker;
        this.scoreDisplayer = scoreDisplayer;
    }

    @Override
    public void startSound(double midi) {
        speaker.start(midi);
    }

    @Override
    public void stopSound() {
        speaker.stop();
    }

    @Override
    public void showClock(ClockViewModel viewModel) {
        gameScreen.showClock(viewModel);
    }

    @Override
    public void showGameStarted(GameStartViewModel viewModel) {
        gameScreen.showGameStart(viewModel);
    }

    @Override
    public void showSong(SongStartViewModel viewModel) {
        gameScreen.showSongStart(viewModel);
    }

    @Override
    public void showRound(RoundEndViewModel viewModel) {
        gameScreen.showSuccess(viewModel);
    }

    @Override
    public void showSongComplete(SongCompleteViewModel viewModel) {
        gameScreen.showSongComplete(viewModel);
    }

    @Override
    public void showError(RoundErrorViewModel viewModel) {
        gameScreen.showError(viewModel);
    }

    @Override
    public void showSharpError(RoundErrorViewModel viewModel) {
        gameScreen.showSharpError(viewModel);
    }

    @Override
    public void showScore(String score) {
        scoreDisplayer.display(score);
    }

    @Override
    public void showGameComplete(GameOverViewModel viewModel) {
        gameScreen.showGameComplete(viewModel);
        scoreDisplayer.clearScore();
    }

}