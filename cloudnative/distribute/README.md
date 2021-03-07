# Distribute

보통 Distribute 단계는 이미지 정의 및 사양을 이용해 컨테이너 이미지를 빌드하고 애플리케이션의 결함을 식별하기 위한 체계적인 테스트들로 구성되는데,
Cloud Native 보안 백서에 따르면 이미지 빌드 시 오픈 소스 및 재사용 가능한 패키지 채택으로 인한 취약점들 또한 컨테이너 이미지에 포함될 수 있으므로 이미지의 무결성을 검증하는 것과 같은 보안 단계를 통합하는 것이 중요하다고 합니다.

![image](https://github.com/cncf/sig-security/blob/master/security-whitepaper/RackMultipart20201111_figure3.png?raw=true)

Cloud Native 보안 백서에서 제시하고 있는 위 그림에 따라 분류된 각 스텝을 실제로 어떤 방식과 절차로 진행하면 좋을지 알아보고 공유해보고자 합니다.

1. Build
> Pipeline 구축에 있어서 CI 서버(또는 툴)은 Github Action 방식이 많이 사용되고 있다고 합니다.
> Github Action의 사용법에 대해서 알아보면 좋을 것 같습니다.

2. Container Registry
> Container Registry는 무엇인지, 사용하는 방법 등에 대해서 알아보면 좋을 것 같습니다.

3. Application Testing
> Unit Tests? System Tests? Integration Tests? Smoke Test? 등등이 무엇인지

4. Security Testing
> Container Image Vulnerability Scan, Security and Compliance Scan 등등이 무엇인지

5. Image Integrity
> Sign Images? Check Integrity?