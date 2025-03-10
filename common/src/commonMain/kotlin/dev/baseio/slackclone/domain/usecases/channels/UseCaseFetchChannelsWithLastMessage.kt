package dev.baseio.slackclone.domain.usecases.channels


import dev.baseio.slackclone.domain.model.channel.DomainLayerChannels
import dev.baseio.slackclone.domain.model.message.DomainLayerMessages
import dev.baseio.slackclone.domain.repository.ChannelLastMessageRepository
import dev.baseio.slackclone.domain.usecases.BaseUseCase
import kotlinx.coroutines.flow.Flow

class UseCaseFetchChannelsWithLastMessage(private val channelLastMessageRepository: ChannelLastMessageRepository) :
  BaseUseCase<List<DomainLayerMessages.LastMessage>, Unit> {

  override fun performStreaming(params: Unit?): Flow<List<DomainLayerMessages.LastMessage>> {
    return channelLastMessageRepository.fetchChannels()
  }

}