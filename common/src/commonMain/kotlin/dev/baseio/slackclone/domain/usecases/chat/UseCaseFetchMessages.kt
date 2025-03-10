package dev.baseio.slackclone.domain.usecases.chat


import dev.baseio.slackclone.domain.model.message.DomainLayerMessages
import dev.baseio.slackclone.domain.repository.MessagesRepository
import dev.baseio.slackclone.domain.usecases.BaseUseCase
import kotlinx.coroutines.flow.Flow

class UseCaseFetchMessages(private val messagesRepository: MessagesRepository) :
  BaseUseCase<List<DomainLayerMessages.SlackMessage>, String> {
  override fun performStreaming(params: String?): Flow<List<DomainLayerMessages.SlackMessage>> {
    return messagesRepository.fetchMessages(params)
  }
}
